package com.github.weather.data.repository.datasourceImpl

import com.github.weather.data.api.CurrentWeatherService
import com.github.weather.data.model.CurrentWeatherDetail
import com.github.weather.data.repository.datasource.CurrentWeatherRemoteDataSource

class CurrentWeatherRemoteDataSourceImpl(private val currentWeatherService: CurrentWeatherService) : CurrentWeatherRemoteDataSource {

    override suspend fun getCurrentWeatherWithLatLong(coordinates: Pair<String, String>): CurrentWeatherDetail? {
        return currentWeatherService.getWeatherByLatLong(coordinates.first, coordinates.second).body()
    }

}