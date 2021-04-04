package com.github.weather.data.model

import com.google.gson.annotations.SerializedName

data class CurrentWeatherDetail(
    @SerializedName("base")
    val base: String?,
    @SerializedName("clouds")
    val clouds: CurrentClouds?,
    @SerializedName("cod")
    val code: Int?,
    @SerializedName("coord")
    val coordinates: CurrentCoordinates?,
    @SerializedName("dt")
    val dt: Long?,
    @SerializedName("id")
    val id: Long?,
    @SerializedName("main")
    val main: CurrentMain?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("sys")
    val sys: CurrentSys?,
    @SerializedName("timezone")
    val timezone: Long?,
    @SerializedName("visibility")
    val visibility: Long?,
    @SerializedName("weather")
    val currentWeather: List<CurrentWeather?>?,
    @SerializedName("wind")
    val currentWind: CurrentWind?
)

data class CurrentCoordinates(
    @SerializedName("lat")
    val latitude: Double?,
    @SerializedName("lon")
    val longitude: Double?
)

data class CurrentClouds(
    @SerializedName("all")
    val all: Long?
)

data class CurrentMain(
    @SerializedName("feels_like")
    val feelsLike: Double?,
    @SerializedName("humidity")
    val humidity: Int?,
    @SerializedName("pressure")
    val pressure: Int?,
    @SerializedName("temp")
    val temp: Double?,
    @SerializedName("temp_max")
    val tempMax: Double?,
    @SerializedName("temp_min")
    val tempMin: Double?
)

data class CurrentSys(
    @SerializedName("country")
    val country: String?,
    @SerializedName("id")
    val id: Long?,
    @SerializedName("sunrise")
    val sunrise: Long?,
    @SerializedName("sunset")
    val sunset: Long?,
    @SerializedName("type")
    val type: Long?
)

data class CurrentWeather(
    @SerializedName("description")
    val description: String?,
    @SerializedName("icon")
    val icon: String?,
    @SerializedName("id")
    val id: Long?,
    @SerializedName("main")
    val main: String?
)

data class CurrentWind(
    @SerializedName("deg")
    val deg: Long?,
    @SerializedName("speed")
    val speed: Double?
)