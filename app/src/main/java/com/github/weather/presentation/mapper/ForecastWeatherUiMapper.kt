package com.github.weather.presentation.mapper

import android.content.Context
import com.github.weather.R
import com.github.weather.data.model.CurrentWeatherDetail
import com.github.weather.data.model.ForecastWeatherDetail
import com.github.weather.presentation.data.CurrentWeatherUiData
import com.github.weather.presentation.data.ForecastWeatherUiData
import com.github.weather.presentation.util.StringUtil.appendDegreeCelsius
import java.util.*

class ForecastWeatherUiMapper(val context: Context) {

    fun getUiModel(forecastWeatherDetail: ForecastWeatherDetail?): ForecastWeatherUiData? {
        val forecastWeatherUiData = ForecastWeatherUiData()
        forecastWeatherDetail?.apply {
            forecastWeatherUiData.temp = "America"
        }
        return forecastWeatherUiData
    }
}