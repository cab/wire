package com.squareup.wire.io

import kotlin.reflect.KClass

expect annotation class Throws(val exception: KClass<*>)

expect open class IOException(message: String) : Throwable

expect class ProtocolException(message: String) : IOException
expect class EOFException() : IOException
