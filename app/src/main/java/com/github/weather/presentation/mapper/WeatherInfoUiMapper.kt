package com.github.weather.presentation.mapper

import android.content.Context
import com.github.weather.R
import com.github.weather.data.model.Forecast
import com.github.weather.data.model.ForecastWeatherDetail
import com.github.weather.presentation.util.StringUtil.appendDegreeCelsius
import java.util.*
import kotlin.collections.ArrayList

class WeatherInfoUiMapper(val context: Context) {

    fun getUiModel(forecastWeatherDetail: ForecastWeatherDetail?, timeStamp: Long): List<Pair<String, String>>? {

        val forecastList = ArrayList<Pair<String, String>>()

        val forecast = forecastWeatherDetail?.forecastList?.filter {
            it?.forecastTimeStamp == timeStamp
        }?.first()

        forecast?.apply {
            forecastList.add(
                Pair(context.getString(R.string.country_name), forecastWeatherDetail.getCountryName()))
            forecastList.add(
                Pair(context.getString(R.string.city_name), forecastWeatherDetail.city?.name ?: ""))
            forecastList.add(
                Pair(context.getString(R.string.temperature), forecastMain?.temperature?.toString()?.appendDegreeCelsius() ?: ""))
            forecastList.add(
                Pair(context.getString(R.string.weather), weather?.get(0)?.main ?: ""))
            forecastList.add(
                Pair(context.getString(R.string.weather_desc), weather?.get(0)?.description ?: ""))
            forecastList.add(
                Pair(context.getString(R.string.max_temperature),forecastMain?.temperatureMaximum?.toString()?.appendDegreeCelsius() ?: ""))
            forecastList.add(
                Pair(context.getString(R.string.min_temperature),forecastMain?.temperatureMinimum?.toString()?.appendDegreeCelsius() ?: ""))
            forecastList.add(
                Pair(context.getString(R.string.wind_info),getWind()))
            forecastList.add(
                Pair(context.getString(R.string.humidity_info),getHumidity()))
            forecastList.add(
                Pair(context.getString(R.string.sea_level),getSeaLevel()))
            forecastList.add(
                Pair(context.getString(R.string.ground_level),getGroundLevel()))
            forecastList.add(
                Pair(context.getString(R.string.pop), "${probabilityOfPrecipitation.toString()}%"))
            forecastList.add(
                Pair(context.getString(R.string.lat),forecastWeatherDetail.getLatitude()))
            forecastList.add(
                Pair(context.getString(R.string.longitude),forecastWeatherDetail.getLongitude()))
            forecastList.add(
                Pair(context.getString(R.string.sunset),forecastWeatherDetail.getSunset()))
            forecastList.add(
                Pair(context.getString(R.string.sunrise),forecastWeatherDetail.getSunrice()))
        }
        return forecastList
    }

    private fun ForecastWeatherDetail.getSunrice() =
        city?.sunrise?.toString()?.let { sunrise ->
            sunrise
        } ?: ""

    private fun ForecastWeatherDetail.getSunset() =
        city?.sunset?.toString()?.let { sunset ->
            sunset
        } ?: ""

    private fun ForecastWeatherDetail.getLongitude() =
        city?.coordinates?.longitude?.let { longitude ->
            longitude.toString()
        } ?: ""

    private fun ForecastWeatherDetail.getLatitude() =
        city?.coordinates?.latitude?.let { latitude ->
            latitude.toString()
        } ?: ""

    private fun Forecast.getGroundLevel() =
        forecastMain?.groundLevel?.toString()?.let { groundLevel ->
            groundLevel
        } ?: ""

    private fun ForecastWeatherDetail.getCountryName() : String {
        return city?.country?.let { country ->
            val locale = Locale("", country)
            return if (locale.displayCountry.isNotEmpty())
                locale.displayCountry
            else
                country
        } ?: ""
    }

    private fun Forecast.getIconUrl(): String {
        weather?.get(0)
        val icon = weather?.get(0)?.icon ?: ""
        return if(icon.isNotEmpty())
            "http://openweathermap.org/img/wn/$icon@2x.png"
        else
            ""
    }

    private fun Forecast.getWind() =
        wind?.speed?.toString()?.let { wind ->
            "$wind m/s"
        } ?: ""

    private fun Forecast.getHumidity() =
        forecastMain?.humidity?.toString()?.let { humidity ->
            "$humidity %"
        } ?: ""

    private fun Forecast.getSeaLevel() =
        forecastMain?.seaLevel?.toString()?.let { seaLevel ->
            seaLevel
        } ?: ""
}