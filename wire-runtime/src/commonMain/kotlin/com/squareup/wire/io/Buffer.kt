package com.squareup.wire.io

import okio.ByteString

expect class Buffer() : BufferedSource, BufferedSink {
    fun clear()
    fun write(bytes: ByteArray): Buffer
    fun write(bytes: ByteString): Buffer
    fun readByteString(): ByteString
    fun readByteArray(): ByteArray
}