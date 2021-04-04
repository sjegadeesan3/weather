package com.github.weather.data.repository.datasourceImpl

import com.github.weather.data.model.CurrentWeatherDetail
import com.github.weather.data.repository.datasource.CurrentWeatherRemoteDataSource

class CurrentWeatherRemoteDataSourceImpl : CurrentWeatherRemoteDataSource {

    override suspend fun getCurrentWeatherWithLatLong(coordinates: Pair<String, String>): CurrentWeatherDetail? {
        TODO("Not yet implemented")
    }

}