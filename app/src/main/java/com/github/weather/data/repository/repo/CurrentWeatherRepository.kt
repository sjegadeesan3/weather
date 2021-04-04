package com.github.weather.data.repository.repo

import com.github.weather.data.model.CurrentWeatherDetail

interface CurrentWeatherRepository {

    suspend fun getCurrentWeatherByLatLong(latitude: String, longitude: String): CurrentWeatherDetail?

}