package com.github.weather.domain.usecase.forecast

import com.github.weather.data.model.ForecastWeatherDetail
import com.github.weather.data.repository.repo.ForecastWeatherRepository
import com.github.weather.domain.usecase.UseCaseWithParameter

class GetForecastWeatherLatLongUseCase (private val forecastWeatherRepository: ForecastWeatherRepository):
    UseCaseWithParameter<Pair<String, String>, ForecastWeatherDetail?>  {

    override suspend fun execute(parameter: Pair<String, String>): ForecastWeatherDetail? {
        return forecastWeatherRepository.getForecastWeatherByLatLong(latitude = parameter.first, longitude = parameter.second
        )
    }

}