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

import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method


/**
 * Converts values of an enum to and from integers using reflection.
 */
internal class RuntimeEnumAdapter<E : WireEnum>(private val type: Class<E>) : EnumAdapter<E>(type) {
    private var fromValueMethod: Method? = null // Lazy to avoid reflection during class loading.

    private fun getFromValueMethod(): Method {
        val method: Method? = this.fromValueMethod
        if (method != null) {
            return method
        }
        try {
            fromValueMethod = type.getMethod("fromValue", Int::class.javaPrimitiveType)
            return fromValueMethod!! /* TODO(cab) -!! */
        } catch (e: NoSuchMethodException) {
            throw AssertionError(e)
        }

    }

    override fun fromValue(value: Int): E? {
        val constant: E
        try {

            constant = getFromValueMethod().invoke(null, value) as E
        } catch (e: IllegalAccessException) {
            throw AssertionError(e)
        } catch (e: InvocationTargetException) {
            throw AssertionError(e)
        }

        return constant
    }

    override fun equals(o: Any?): Boolean {
        return o is RuntimeEnumAdapter<*> && o.type == type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }
}
