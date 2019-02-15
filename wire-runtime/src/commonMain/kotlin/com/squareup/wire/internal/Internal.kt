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
package com.squareup.wire.internal

import com.squareup.wire.ProtoAdapter

/** Methods for generated code use only. Not subject to public API rules.  */
object Internal {

    fun <T> newMutableList(): List<T> {
        return mutableListOf()
    }

    fun <K, V> newMutableMap(): Map<K, V> {
        return LinkedHashMap()
    }

    fun <T> copyOf(name: String, list: List<T>?): List<T> {
        if (list == null) throw NullPointerException("$name == null")
        return if (list === emptyList<Any>() || list is List) {
            list.toMutableList()
        } else ArrayList(list)
    }

    fun <K, V> copyOf(name: String, map: Map<K, V>?): Map<K, V> {
        if (map == null) throw NullPointerException("$name == null")
        return LinkedHashMap(map)
    }

    fun <T> immutableCopyOf(name: String, list: List<T>?): List<T> {
        return list?.toList() ?: listOf()
    }

    fun <K, V> immutableCopyOf(name: String, map: Map<K?, V?>?): Map<K, V> {
        if (map == null) throw NullPointerException("$name == null")
        if (map.isEmpty()) {
            return emptyMap()
        }
        val result = LinkedHashMap(map)
        // Check after the map has been copied to defend against races.
        if (result.containsKey(null)) {
            throw IllegalArgumentException("$name.containsKey(null)")
        }
        if (result.containsValue(null)) {
            throw IllegalArgumentException("$name.containsValue(null)")
        }
        return map as Map<K, V>
    }

    fun <T> redactElements(list: MutableList<T>, adapter: ProtoAdapter<T>) {
        var i = 0
        val count = list.size
        while (i < count) {
            list.set(i, adapter.redact(list[i])!!) /* TODO(cab) -!! */
            i++
        }
    }

    fun <T> redactElements(map: MutableMap<*, T>, adapter: ProtoAdapter<T>) {
        for (entry in map.entries) {
            entry.setValue(adapter.redact(entry.value)!!) /* TODO(cab) -!! */
        }
    }

    fun equals(a: Any?, b: Any): Boolean {
        return a === b || a != null && a == b
    }

    /**
     * Create an exception for missing required fields.
     *
     * @param args Alternating field value and field name pairs.
     */
    fun missingRequiredFields(vararg args: Any): IllegalStateException {
        val sb = StringBuilder()
        var plural = ""
        var i = 0
        val size = args.size
        while (i < size) {
            if (args[i] == null) {
                if (sb.length > 0) {
                    plural = "s" // Found more than one missing field
                }
                sb.append("\n  ")
                sb.append(args[i + 1])
            }
            i += 2
        }
        throw IllegalStateException("Required field$plural not set:$sb")
    }

    /** Throw [NullPointerException] if `list` or one of its items are null.  */
    fun checkElementsNotNull(list: List<*>?) {
        if (list == null) throw NullPointerException("list == null")
        var i = 0
        val size = list.size
        while (i < size) {
            val element = list[i] ?: throw NullPointerException("Element at index $i is null")
            i++
        }
    }

    /** Throw [NullPointerException] if `map` or one of its keys or values are null.  */
    fun checkElementsNotNull(map: Map<*, *>?) {
        if (map == null) throw NullPointerException("map == null")
        for ((key, value) in map) {
            if (key == null) {
                throw NullPointerException("map.containsKey(null)")
            }
            if (value == null) {
                throw NullPointerException("Value for key $key is null")
            }
        }
    }

    /** Returns the number of non-null values in `a, b`.  */
    fun countNonNull(a: Any?, b: Any?): Int {
        return (if (a != null) 1 else 0) + if (b != null) 1 else 0
    }

    /** Returns the number of non-null values in `a, b, c`.  */
    fun countNonNull(a: Any?, b: Any?, c: Any?): Int {
        return ((if (a != null) 1 else 0)
                + (if (b != null) 1 else 0)
                + if (c != null) 1 else 0)
    }

    /** Returns the number of non-null values in `a, b, c, d, rest`.  */
    fun countNonNull(a: Any?, b: Any?, c: Any?, d: Any?, vararg rest: Any): Int {
        var result = 0
        if (a != null) result++
        if (b != null) result++
        if (c != null) result++
        if (d != null) result++
        for (o in rest) {
            if (o != null) result++
        }
        return result
    }
}
