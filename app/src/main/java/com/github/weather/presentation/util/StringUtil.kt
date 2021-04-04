package com.github.weather.presentation.util

object StringUtil {
    fun String.appendDegreeCelsius(): String {
        return "${this}ºC"
    }
}