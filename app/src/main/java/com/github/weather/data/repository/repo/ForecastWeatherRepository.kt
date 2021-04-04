package com.github.weather.data.repository.repo

import com.github.weather.data.model.ForecastWeatherDetail

interface ForecastWeatherRepository {

    suspend fun getForecastWeatherByLatLong(latitude: String, longitude: String): ForecastWeatherDetail?

}
