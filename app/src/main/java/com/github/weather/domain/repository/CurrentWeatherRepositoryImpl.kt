package com.github.weather.domain.repository

import com.github.weather.data.model.CurrentWeatherDetail
import com.github.weather.data.repository.datasource.CurrentWeatherRemoteDataSource
import com.github.weather.data.repository.repo.CurrentWeatherRepository

class CurrentWeatherRepositoryImpl(private val currentWeatherRemoteDataSource: CurrentWeatherRemoteDataSource): CurrentWeatherRepository {

    override suspend fun getCurrentWeatherByLatLong(latitude: String, longitude: String): CurrentWeatherDetail? {
        TODO("Not yet implemented")
    }

}