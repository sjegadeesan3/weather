package com.github.weather.data.api

import com.github.weather.BuildConfig
import com.github.weather.data.model.CurrentWeatherDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrentWeatherService {

    @GET("weather")
    suspend fun getWeatherByLatLong(@Query("lat")latitude: String,
                                     @Query("lon")longitude: String,
                                     @Query("appid")apiKey: String = BuildConfig.API_KEY): Response<CurrentWeatherDetail>

}