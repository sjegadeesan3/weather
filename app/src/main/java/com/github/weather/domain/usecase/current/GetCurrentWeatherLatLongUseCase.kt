package com.github.weather.domain.usecase.current

import com.github.weather.data.model.CurrentWeatherDetail
import com.github.weather.data.repository.repo.CurrentWeatherRepository
import com.github.weather.domain.usecase.UseCaseWithParameter

class GetCurrentWeatherLatLongUseCase(private val currentWeatherRepository: CurrentWeatherRepository)
    : UseCaseWithParameter<Pair<String, String>, CurrentWeatherDetail?> {

    override suspend fun execute(parameter: Pair<String, String>): CurrentWeatherDetail? {
        return currentWeatherRepository.getCurrentWeatherByLatLong(
            latitude = parameter.first,
            longitude = parameter.second)
    }

}