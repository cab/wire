/*
 * Copyright 2015 Square Inc.
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

import kotlin.reflect.*

/**
 * Read, write, and describe a tag within a message. This class knows how to assign fields to a
 * builder object, and how to extract values from a message object.
 */
internal class FieldBinding<M : Message<M, B>, B : Message.Builder<M, B>>(wireField: WireField, private val messageField: KMutableProperty<Any>, builderType: KClass<B>) {

    val label: WireField.Label
    val name: String
    val tag: Int
    private val keyAdapterString: String
    private val adapterString: String
    val redacted: Boolean
    private val builderField: KMutableProperty<Any>
    private val builderMethod: KFunction<Any>

    // Delegate adapters are created lazily; otherwise we could stack overflow!
    private var singleAdapter: ProtoAdapter<*>? = null
    private var keyAdapter: ProtoAdapter<*>? = null
    private var adapter: ProtoAdapter<Any>? = null

    val isMap: Boolean
        get() = !keyAdapterString.isEmpty()

    private fun getBuilderField(builderType: KClass<*>, name: String): KMutableProperty<Any> {
        try {
            return builderType.members.find { it.name == name && it is KMutableProperty }!! as KMutableProperty<Any> /* TODO(cab) */
        } catch (e: NullPointerException) {
            throw AssertionError("No builder field " + builderType.qualifiedName
                    + "." + name)
        }
    }

    private fun getBuilderMethod(builderType: KClass<*>, name: String, type: KType): KFunction<Any> {
        try {
            return builderType.members.find { it.name == name && it is KFunction }!! as KFunction<Any> /* TODO(cab) */
        } catch (e: NullPointerException) {
            throw AssertionError("No builder method " + builderType.qualifiedName + "." + name
                    + "(" + type.toString() + ")")
        }

    }

    init {
        this.label = wireField.label
        this.name = messageField.name
        this.tag = wireField.tag
        this.keyAdapterString = wireField.keyAdapter
        this.adapterString = wireField.adapter
        this.redacted = wireField.redacted
        this.builderField = getBuilderField(builderType, name)
        this.builderMethod = getBuilderMethod(builderType, name, messageField.returnType)
    }

    fun singleAdapter(): ProtoAdapter<*> {
        val result = singleAdapter
        if(result != null) {
            return result
        } else {
            singleAdapter = ProtoAdapter[adapterString]
            return singleAdapter!! /* TODO(cab) -!! */
        }
    }

    fun keyAdapter(): ProtoAdapter<*> {
        val result = keyAdapter
        if(result != null) {
            return result
        } else {
            keyAdapter = ProtoAdapter[keyAdapterString]
            return keyAdapter!! /* TODO(cab) -!! */
        }
    }

    fun adapter(): ProtoAdapter<Any> {
        val result = adapter
        if (result != null) return result
        if (isMap) {
            val keyAdapter = keyAdapter() as ProtoAdapter<Any>
            val valueAdapter = singleAdapter() as ProtoAdapter<Any>
            adapter = ProtoAdapter.newMapAdapter(keyAdapter,
                    valueAdapter) as ProtoAdapter<Any>
            return adapter!! /* TODO(cab) -!! */
        }
        adapter = singleAdapter().withLabel(label) as ProtoAdapter<Any>
        return adapter!! /* TODO(cab) -!! */
    }

    /** Accept a single value, independent of whether this value is single or repeated.  */
    fun value(builder: B, value: Any) {
        if (label.isRepeated) {
            val list = getFromBuilder(builder) as MutableList<Any>
            list.add(value)
        } else if (!keyAdapterString.isEmpty()) {
            val map = getFromBuilder(builder) as MutableMap<Any, Any>
            map.putAll(value as Map<Any, Any>)
        } else {
            set(builder, value)
        }
    }

    /** Assign a single value for required/optional fields, or a list for repeated/packed fields.  */
    operator fun set(builder: B, value: Any) {
//        try {
            if (label.isOneOf) {
                // In order to maintain the 'oneof' invariant, call the builder setter method rather
                // than setting the builder field directly.
                builderMethod.call(builder, value)
            } else {
                builderField.setter.call(builder, value)
            }
//        } catch (e: IllegalAccessException) {
//            throw AssertionError(e)
//        } catch (e: InvocationTargetException) {
//            throw AssertionError(e)
//        }

    }

    operator fun get(message: M): Any {
//        try {
            return messageField.getter.call(message)
//        } catch (e: IllegalAccessException) {
//            throw AssertionError(e)
//        }

    }

    fun getFromBuilder(builder: B): Any {
//        try {
            return builderField.getter.call(builder)
//        } catch (e: IllegalAccessException) {
//            throw AssertionError(e)
//        }

    }
}
