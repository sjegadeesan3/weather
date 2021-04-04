package com.github.weather.presentation.mapper

import android.content.Context
import com.github.weather.data.model.Forecast
import com.github.weather.data.model.ForecastWeatherDetail
import com.github.weather.presentation.data.ForecastDayWeatherUiData
import com.github.weather.presentation.util.CalenderUtil.getHourAndSecondFromDate
import com.github.weather.presentation.util.StringUtil.appendDegreeCelsius

class ForecastDayWeatherUiMapper(val context: Context) {

    fun getUiModel(forecastWeatherDetail: ForecastWeatherDetail?, listSize: Int): List<ForecastDayWeatherUiData>? {

        val forecastWeatherUiDataList = mutableListOf<ForecastDayWeatherUiData>()
        var count = 0
        forecastWeatherDetail?.forecastList?.forEach { forecast ->
            if(listSize > count) {
                count += 1
                val forecastWeatherUiData = ForecastDayWeatherUiData()
                forecastWeatherUiData.time = getHourAndSecondFromDate(forecast.forecastDateTime)
                forecastWeatherUiData.temp = forecast.forecastMain.temperature.toString().appendDegreeCelsius()
                forecastWeatherUiData.iconUrl = getIconUrl(forecast)
                forecastWeatherUiDataList.add(forecastWeatherUiData)
            }
        }
        return forecastWeatherUiDataList
    }

    private fun getIconUrl(forecast: Forecast): String {
        val icon = forecast.weather[0].icon
        val c = "http://openweathermap.org/img/wn/$icon@2x.png"
        return c
    }

}