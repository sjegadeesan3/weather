package com.github.weather.data.repository.datasource

import com.github.weather.data.model.CurrentWeatherDetail

interface CurrentWeatherRemoteDataSource {

    suspend fun getCurrentWeatherWithLatLong(latitude: String, longitude: String): CurrentWeatherDetail?

}