package com.github.weather.data.repository.datasource

import com.github.weather.data.model.ForecastWeatherDetail

interface ForecastWeatherRemoteDataSource {

    suspend fun getCurrentWeatherWithLatLong(coordinates: Pair<String, String>): ForecastWeatherDetail?

}