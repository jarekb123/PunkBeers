package com.butajlo.punkbeers.data.test

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.reflect.Type

class TestUtils private constructor() {

    companion object {
        private val INSTANCE = TestUtils()
        private val GSON = Gson()

        fun <T> loadJson(filePath: String, tClass: Class<T>): T = GSON.fromJson(getFileString(filePath), tClass)

        fun <T> loadJson(filePath: String, type: Type): T = GSON.fromJson(getFileString(filePath), type)

        fun <C, P> getGenericType (clazz: Class<C>, parameterClass: Class<P>): Type {
            return GenericOf(clazz, parameterClass).rawType
        }

        private fun getFileString(filePath: String): String {
            val sb = StringBuilder()
            val reader = BufferedReader(InputStreamReader(INSTANCE.javaClass.classLoader.getResourceAsStream(filePath)))

            var line = reader.readLine()
            while (line != null) {
                sb.append(line)
                line = reader.readLine()
            }

            return sb.toString()
        }
    }
}