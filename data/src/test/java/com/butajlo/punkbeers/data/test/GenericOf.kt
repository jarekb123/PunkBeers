package com.butajlo.punkbeers.data.test

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

class GenericOf<X, Y>(private val container: Class<X>, private val wrapped: Class<Y>) : ParameterizedType {

    override fun getRawType() = container

    override fun getOwnerType() = null

    override fun getActualTypeArguments() = arrayOf<Type>(wrapped)
}