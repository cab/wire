package com.squareup.wire.io

import okio.ByteString

interface BufferedSource {
    fun exhausted(): Boolean
    fun skip(bytes: Long): Boolean
    fun require(bytes: Long): Boolean
    fun readByte(): Byte
    fun readIntLe(): Int
    fun readLongLe(): Long
    fun readByteString(bytes: Long): ByteString
    fun readUtf8(bytes: Long): String
}