package com.squareup.wire.io

import okio.ByteString

interface BufferedSink {
    fun writeUtf8(bytes: String)
    fun write(bytes: ByteString)
    fun writeByte(byte: Byte)
    fun writeIntLe(int: Int)
    fun writeLongLe(long: Long)
}