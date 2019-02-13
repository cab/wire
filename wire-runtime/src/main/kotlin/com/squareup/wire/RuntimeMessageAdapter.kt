/*
 * Copyright 2013 Square Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.squareup.wire

import com.squareup.wire.internal.Internal
import java.io.IOException
import java.lang.reflect.Field
import java.util.Collections
import java.util.LinkedHashMap

import com.squareup.wire.Message.Builder

internal class RuntimeMessageAdapter<M : Message<M, B>, B : Builder<M, B>>(private val messageType: Class<M>, private val builderType: Class<B>,
                                                                           private val fieldBindings: Map<Int, FieldBinding<M, B>>) : ProtoAdapter<M>(FieldEncoding.LENGTH_DELIMITED, messageType) {

    fun fieldBindings(): Map<Int, FieldBinding<M, B>> {
        return fieldBindings
    }

    fun newBuilder(): B {
        try {
            return builderType.newInstance()
        } catch (e: IllegalAccessException) {
            throw AssertionError(e)
        } catch (e: InstantiationException) {
            throw AssertionError(e)
        }

    }

    override fun encodedSize(message: M): Int {
        val cachedSerializedSize = message.cachedSerializedSize
        if (cachedSerializedSize != 0) return cachedSerializedSize

        var size = 0
        for (fieldBinding in fieldBindings.values) {
            val value = fieldBinding[message] ?: continue
            size += fieldBinding.adapter().encodedSizeWithTag(fieldBinding.tag, value)
        }
        size += message.unknownFields().size

        message.cachedSerializedSize = size
        return size
    }

    @Throws(IOException::class)
    override fun encode(writer: ProtoWriter, message: M) {
        for (fieldBinding in fieldBindings.values) {
            val value = fieldBinding[message] ?: continue
            fieldBinding.adapter().encodeWithTag(writer, fieldBinding.tag, value)
        }
        writer.writeBytes(message.unknownFields())
    }

    override fun redact(message: M): M {
        val builder = message.newBuilder()
        for (fieldBinding in fieldBindings.values) {
            if (fieldBinding.redacted && fieldBinding.label === WireField.Label.REQUIRED) {
                throw UnsupportedOperationException(String.format(
                        "Field '%s' in %s is required and cannot be redacted.",
                        fieldBinding.name, javaType?.getName()))
            }
            val isMessage = Message::class.java.isAssignableFrom(fieldBinding.singleAdapter().javaType)
            if (fieldBinding.redacted || isMessage && !fieldBinding.label.isRepeated) {
                val builderValue = fieldBinding.getFromBuilder(builder)
                if (builderValue != null) {
                    val redactedValue = fieldBinding.adapter().redact(builderValue)
                    fieldBinding[builder] = redactedValue!!
                }
            } else if (isMessage && fieldBinding.label.isRepeated) {

                val values = fieldBinding.getFromBuilder(builder) as List<Any>

                val adapter = fieldBinding.singleAdapter() as ProtoAdapter<Any>
                Internal.redactElements(values, adapter)
            }
        }
        builder.clearUnknownFields()
        return builder.build()
    }

    override fun equals(o: Any?): Boolean {
        return o is RuntimeMessageAdapter<*, *> && o.messageType == messageType
    }

    override fun hashCode(): Int {
        return messageType.hashCode()
    }

    override fun toString(message: M): String {
        val sb = StringBuilder()
        for (fieldBinding in fieldBindings.values) {
            val value = fieldBinding[message]
            if (value != null) {
                sb.append(", ")
                        .append(fieldBinding.name)
                        .append('=')
                        .append(if (fieldBinding.redacted) REDACTED else value)
            }
        }

        // Replace leading comma with class name and opening brace.
        sb.replace(0, 2, messageType.simpleName + '{')
        return sb.append('}').toString()
    }

    @Throws(IOException::class)
    override fun decode(reader: ProtoReader): M {
        val builder = newBuilder()
        val token = reader.beginMessage()
        var tag: Int
        loop@ do {
            tag = reader.nextTag()
            if(tag == -1) {
                break@loop
            }
            val fieldBinding = fieldBindings[tag]
            try {
                if (fieldBinding != null) {
                    val adapter = if (fieldBinding.isMap)
                        fieldBinding.adapter()
                    else
                        fieldBinding.singleAdapter()
                    val value = adapter.decode(reader)
                    fieldBinding.value(builder, value!!)
                } else {
                    val fieldEncoding = reader.peekFieldEncoding()
                    val value = fieldEncoding!!.rawProtoAdapter().decode(reader)
                    builder.addUnknownField(tag, fieldEncoding, value)
                }
            } catch (e: ProtoAdapter.EnumConstantNotFoundException) {
                // An unknown Enum value was encountered, store it as an unknown field.
                builder.addUnknownField(tag, FieldEncoding.VARINT, e.value.toLong())
            }

        } while (tag != -1)
        reader.endMessage(token)

        return builder.build()
    }

    companion object {
        private val REDACTED = "\u2588\u2588"

        fun <M : Message<M, B>, B : Builder<M, B>> create(
                messageType: Class<M>): RuntimeMessageAdapter<M, B> {
            val builderType = getBuilderType(messageType)
            val fieldBindings = LinkedHashMap<Int, FieldBinding<M, B>>()

            // Create tag bindings for fields annotated with '@WireField'
            for (messageField in messageType.declaredFields) {
                val wireField = messageField.getAnnotation(WireField::class.java)
                if (wireField != null) {
                    fieldBindings[wireField.tag] = FieldBinding(wireField, messageField, builderType)
                }
            }

            return RuntimeMessageAdapter(messageType, builderType,
                    Collections.unmodifiableMap(fieldBindings))
        }

        private fun <M : Message<M, B>, B : Builder<M, B>> getBuilderType(
                messageType: Class<M>): Class<B> {
            try {
                return Class.forName(messageType.name + "\$Builder") as Class<B>
            } catch (e: ClassNotFoundException) {
                throw IllegalArgumentException("No builder class found for message type " + messageType.name)
            }

        }
    }
}
