package com.github.weather.presentation

import android.app.Application
import com.github.weather.presentation.di.appModule
import com.github.weather.presentation.di.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class WeatherApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@WeatherApplication)
            modules(appModule, networkModule)
        }
    }
}