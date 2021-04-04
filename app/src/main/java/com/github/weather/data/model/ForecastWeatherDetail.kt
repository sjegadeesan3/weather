package com.github.weather.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/*
 * Please visit the below website for api description
 * https://openweathermap.org/forecast5
 * */

@Entity(tableName = "forecast_weather_detail")
data class ForecastWeatherDetail(
    @SerializedName("city")
    val city: City?,
    @PrimaryKey
    @SerializedName("cnt")
    val count: Int?,
    @SerializedName("cod")
    val responseCode: String?, //200
    @SerializedName("list")
    val forecastList: List<Forecast?>?,
    @SerializedName("message")
    val message: Int?
    //val message: String
)

data class City(
    @SerializedName("coord")
    val coordinates: Coordinates?,
    @SerializedName("country")
    val country: String?,
    @SerializedName("id")
    @PrimaryKey
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("population")
    val population: Long?,
    @SerializedName("sunrise")
    val sunrise: Long?,
    @SerializedName("sunset")
    val sunset: Long?,
    @SerializedName("timezone")
    val timezone: Long?
)

data class Forecast(
    @SerializedName("clouds")
    val clouds: ForecastClouds?,
    @SerializedName("dt")
    val forecastTimeStamp: Long?,//https://www.epochconverter.com/
    @SerializedName("dt_txt")
    val forecastDateTime: String?,
    @SerializedName("main")
    val forecastMain: ForecastMain?,
    @SerializedName("pop")
    val probabilityOfPrecipitation: Double?,
    @SerializedName("sys")
    val sys: ForecastSys?,
    @SerializedName("visibility")
    val visibility: Int?,
    @SerializedName("weather")
    val weather: List<ForecastWeather?>?,
    @SerializedName("wind")
    val wind: ForecastWind?
)

data class Coordinates(
    @SerializedName("lat")
    val latitude: Double?,
    @SerializedName("lon")
    val longitude: Double?
)

data class ForecastClouds(
    @SerializedName("all")
    val all: Int?
)


data class ForecastMain(
    @SerializedName("feels_like")
    val feelsLike: Double?,
    @SerializedName("grnd_level")
    val groundLevel: Int?,
    @SerializedName("humidity")
    val humidity: Int?,
    @SerializedName("pressure")
    val pressure: Int?,
    @SerializedName("sea_level")
    val seaLevel: Int?,
    @SerializedName("temp") // Default Kelvin
    val temperature: Double?,
    @SerializedName("temp_kf")
    val tempKf: Double?,
    @SerializedName("temp_max")
    val temperatureMaximum: Double?,
    @SerializedName("temp_min")
    val temperatureMinimum: Double?
)

data class ForecastSys(
    @SerializedName("pod")
    val partOfTheDay: String? //Part of the day (n - night, d - day)
)

data class ForecastWeather(
    @SerializedName("description")
    val description: String?,
    @SerializedName("icon")
    val icon: String?, //http://openweathermap.org/img/wn/{{icon}}@2x.png
    @SerializedName("id")
    val id: Int?,
    @SerializedName("main")
    val main: String?
)

data class ForecastWind(
    @SerializedName("deg")
    val deg: Int?,
    @SerializedName("speed")
    val speed: Double?
)