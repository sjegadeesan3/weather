package com.github.weather.data.repository.datasourceImpl

import com.github.weather.data.api.CurrentWeatherService
import com.github.weather.data.model.CurrentWeatherDetail
import com.github.weather.data.repository.datasource.CurrentWeatherRemoteDataSource

class CurrentWeatherRemoteDataSourceImpl(private val currentWeatherService: CurrentWeatherService) : CurrentWeatherRemoteDataSource {

    override suspend fun getCurrentWeatherWithLatLong(latitude: String, longitude: String): CurrentWeatherDetail? {
        return currentWeatherService.getWeatherByLatLong(latitude, longitude).body()
    }

}