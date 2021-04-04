package com.github.weather.presentation.mapper

import android.content.Context
import com.github.weather.data.model.Forecast
import com.github.weather.data.model.ForecastWeatherDetail
import com.github.weather.presentation.data.DateWiseWeatherUiData
import com.github.weather.presentation.data.ForecastDayWeatherUiData
import com.github.weather.presentation.util.CalenderUtil.getFormattedDateTime

class DateWiseWeatherUiMapper(val context: Context) {

    fun getUiModel(forecastWeatherDetail: ForecastWeatherDetail?): List<DateWiseWeatherUiData>? {

        val dateWiseWeatherUiDataList = mutableListOf<DateWiseWeatherUiData>()

        forecastWeatherDetail?.forecastList?.forEach { forecast ->

            val dateWiseWeatherUiData = DateWiseWeatherUiData()
            dateWiseWeatherUiData.time = getFormattedDateTime(forecast?.forecastDateTime)
            dateWiseWeatherUiData.icon = getIconUrl(forecast)
            dateWiseWeatherUiDataList.add(dateWiseWeatherUiData)
        }
        return dateWiseWeatherUiDataList
    }

    private fun getIconUrl(forecast: Forecast?): String {
        forecast?.weather?.get(0)
        val icon = forecast?.weather?.get(0)?.icon ?: ""
        return if(icon.isNotEmpty())
            "http://openweathermap.org/img/wn/$icon@2x.png"
        else
            ""
    }

}