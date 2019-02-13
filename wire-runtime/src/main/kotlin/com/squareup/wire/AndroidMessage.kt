/*
 * Copyright 2016 Square Inc.
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

import android.os.Parcel
import android.os.Parcelable
import java.io.IOException
import java.lang.reflect.Array
import okio.ByteString

/** An Android-specific [Message] which adds support for [Parcelable].  */
abstract class AndroidMessage<M : Message<M, B>, B : Message.Builder<M, B>> protected constructor(adapter: ProtoAdapter<M>, unknownFields: ByteString) : Message<M, B>(adapter, unknownFields), Parcelable {

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeByteArray(encode())
    }

    override fun describeContents(): Int {
        return 0
    }

    private class ProtoAdapterCreator<M> internal constructor(private val adapter: ProtoAdapter<M>) : Parcelable.Creator<M> {

        override fun createFromParcel(`in`: Parcel): M {
            try {
                return adapter.decode(`in`.createByteArray())
            } catch (e: IOException) {
                throw RuntimeException(e)
            }

        }

        override fun newArray(size: Int): kotlin.Array<M> {
            return Array.newInstance(adapter.javaType, size) as kotlin.Array<M> /* TODO(cab) unchecked cast */
        }
    }

    companion object {
        /** Creates a new [Parcelable.Creator] using `adapter` for serialization.  */
        fun <E> newCreator(adapter: ProtoAdapter<E>): Parcelable.Creator<E> {
            return ProtoAdapterCreator(adapter)
        }
    }
}
