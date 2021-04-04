package com.github.weather.data.api

import com.github.weather.BuildConfig
import com.github.weather.data.model.ForecastWeatherDetail
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ForecastWeatherService {

    @GET("forecast")
    suspend fun getForecastWeatherByLatLong(@Query("lat")latitude: String,
                                            @Query("lon")longitude: String,
                                            @Query("units")units: String = "metric",
                                            @Query("appid")apiKey: String = BuildConfig.API_KEY): Response<ForecastWeatherDetail>

}