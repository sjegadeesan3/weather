package com.github.weather.data.repository.datasourceImpl

import com.github.weather.data.api.ForecastWeatherService
import com.github.weather.data.model.ForecastWeatherDetail
import com.github.weather.data.repository.datasource.ForecastWeatherRemoteDataSource

class ForecastWeatherRemoteDataSourceImpl(private val forecastWeatherService: ForecastWeatherService) : ForecastWeatherRemoteDataSource {

    override suspend fun getCurrentWeatherWithLatLong(latitude: String, longitude: String): ForecastWeatherDetail? {
        return forecastWeatherService.getForecastWeatherByLatLong(latitude = latitude, longitude = longitude).body()
    }

}