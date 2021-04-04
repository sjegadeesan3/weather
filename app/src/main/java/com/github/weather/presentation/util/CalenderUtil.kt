package com.github.weather.presentation.util

import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

object CalenderUtil {

    fun getHourAndSecondFromDate(dateTime: String): String {
        return try {
            val utcSimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            utcSimpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
            val utcDate: Date? = utcSimpleDateFormat.parse(dateTime);

            val localSimpleDateFormat = SimpleDateFormat("hh:mm a", Locale.ENGLISH);
            localSimpleDateFormat.timeZone = Calendar.getInstance().timeZone
            return utcDate?.let {
                localSimpleDateFormat.format(utcDate)
            } ?: ""
        } catch (e: Exception) {
            ""
        }
    }

    fun getFormattedDateTime(dateTime: String): String {
        return try {
            val utcSimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);
            utcSimpleDateFormat.timeZone = TimeZone.getTimeZone("UTC")
            val utcDate: Date? = utcSimpleDateFormat.parse(dateTime);

            val localSimpleDateFormat = SimpleDateFormat("EEE, MMMM (hh:mm a)", Locale.ENGLISH);
            localSimpleDateFormat.timeZone = Calendar.getInstance().timeZone
            return utcDate?.let {
                localSimpleDateFormat.format(utcDate)
            } ?: ""
        } catch (e: Exception) {
            ""
        }
    }
}