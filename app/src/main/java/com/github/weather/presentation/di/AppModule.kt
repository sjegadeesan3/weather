package com.github.weather.presentation.di

import com.github.weather.data.api.CurrentWeatherService
import com.github.weather.data.api.ForecastWeatherService
import com.github.weather.data.repository.datasource.CurrentWeatherRemoteDataSource
import com.github.weather.data.repository.datasource.ForecastWeatherRemoteDataSource
import com.github.weather.data.repository.datasourceImpl.CurrentWeatherRemoteDataSourceImpl
import com.github.weather.data.repository.datasourceImpl.ForecastWeatherRemoteDataSourceImpl
import com.github.weather.data.repository.repo.CurrentWeatherRepository
import com.github.weather.data.repository.repo.ForecastWeatherRepository
import com.github.weather.domain.repository.CurrentWeatherRepositoryImpl
import com.github.weather.domain.repository.ForecastWeatherRepositoryImpl
import com.github.weather.domain.usecase.current.GetCurrentWeatherLatLongUseCase
import com.github.weather.domain.usecase.forecast.GetForecastWeatherLatLongUseCase
import org.koin.dsl.module
import retrofit2.Retrofit

val appModule = module {

    factory { GetCurrentWeatherLatLongUseCase(get()) }
    factory { GetForecastWeatherLatLongUseCase(get()) }

    single<CurrentWeatherRepository> { CurrentWeatherRepositoryImpl(get()) }
    single<ForecastWeatherRepository> { ForecastWeatherRepositoryImpl(get()) }

    single<CurrentWeatherRemoteDataSource> { CurrentWeatherRemoteDataSourceImpl(get()) }
    single<ForecastWeatherRemoteDataSource> { ForecastWeatherRemoteDataSourceImpl(get()) }

    single { get<Retrofit>().create(ForecastWeatherService::class.java) }
    single { get<Retrofit>().create(CurrentWeatherService::class.java) }

}