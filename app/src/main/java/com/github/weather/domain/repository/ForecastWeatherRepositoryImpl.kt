package com.github.weather.domain.repository

import com.github.weather.data.model.ForecastWeatherDetail
import com.github.weather.data.repository.datasource.ForecastWeatherRemoteDataSource
import com.github.weather.data.repository.repo.ForecastWeatherRepository

class ForecastWeatherRepositoryImpl(private val forecastWeatherRemoteDataSource: ForecastWeatherRemoteDataSource) : ForecastWeatherRepository {

    override suspend fun getForecastWeatherByLatLong(latitude: String, longitude: String): ForecastWeatherDetail? {
        return forecastWeatherRemoteDataSource.getCurrentWeatherWithLatLong(latitude, longitude)
    }

}