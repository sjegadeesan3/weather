package com.github.weather.presentation.mapper

import android.content.Context
import com.github.weather.R
import com.github.weather.data.model.CurrentWeatherDetail
import com.github.weather.presentation.data.CurrentWeatherUiData
import com.github.weather.presentation.util.StringUtil.appendDegreeCelsius

class CurrentWeatherUiMapper(val context: Context) {

    fun getUiModel(currentWeatherDetail: CurrentWeatherDetail?): CurrentWeatherUiData {
        val currentWeatherUiData = CurrentWeatherUiData()
        currentWeatherDetail?.apply {
            currentWeatherUiData.countryName = sys?.country ?: ""
            currentWeatherUiData.city = name ?: ""
            currentWeatherUiData.temperature = main?.temp?.toString()?.appendDegreeCelsius() ?: ""
            currentWeatherUiData.weatherMain = currentWeather?.get(0)?.main ?: ""
            currentWeatherUiData.weatherDescription = currentWeather?.get(0)?.description ?: ""

            currentWeatherUiData.temperatureMax = getTemperatureMax()
            currentWeatherUiData.temperatureMin = getTemperatureMin()
            currentWeatherUiData.wind = getWind()
            currentWeatherUiData.humidity = getHumidity()
        }
        return currentWeatherUiData
    }

    private fun CurrentWeatherDetail.getHumidity() =
        main?.humidity?.toString()?.let { humidity ->
            String.format(context.getString(R.string.humidity), humidity)
        } ?: ""

    private fun CurrentWeatherDetail.getWind() =
        currentWind?.speed?.toString()?.let { wind ->
            String.format(context.getString(R.string.wind), wind)
        } ?: ""

    private fun CurrentWeatherDetail.getTemperatureMin() =
        main?.tempMin?.toString()?.appendDegreeCelsius()?.let { tempMin ->
            String.format(context.getString(R.string.temp_min), tempMin)
        } ?: ""

    private fun CurrentWeatherDetail.getTemperatureMax() =
        main?.tempMax?.toString()?.appendDegreeCelsius()?.let { tempMax ->
            String.format(context.getString(R.string.temp_max), tempMax)
        } ?: ""
}