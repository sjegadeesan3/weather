package com.github.weather.presentation.di

import com.github.weather.presentation.constants.AppConstants.APP_BASE_URL
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single { getRetrofit() }
}

private fun getRetrofit(): Retrofit {
    return Retrofit.Builder()
        .baseUrl(APP_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}