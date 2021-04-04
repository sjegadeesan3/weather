package com.github.weather.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.weather.domain.usecase.current.GetCurrentWeatherLatLongUseCase
import com.github.weather.domain.usecase.forecast.GetForecastWeatherLatLongUseCase
import com.github.weather.presentation.data.CurrentWeatherUiData
import com.github.weather.presentation.mapper.CurrentWeatherUiMapper
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    private val getCurrentWeatherLatLongUseCase: GetCurrentWeatherLatLongUseCase by inject()
    private val getForecastWeatherLatLongUseCase: GetForecastWeatherLatLongUseCase by inject()
    private val currentWeatherUiMapper: CurrentWeatherUiMapper by inject()

    private val mLatitudeAndLongitude: MutableLiveData<Pair<String, String>> = MutableLiveData()
    val latitudeAndLongitude: LiveData<Pair<String, String>>
        get() = mLatitudeAndLongitude


    private val mCurrentWeatherUiData: MutableLiveData<CurrentWeatherUiData?> = MutableLiveData()
    val currentWeatherUiData: LiveData<CurrentWeatherUiData?>
        get() = mCurrentWeatherUiData


    fun setLatitudeAndLongitude(latitude: String, longitude: String) {
        val latLong = Pair(latitude, longitude)
        mLatitudeAndLongitude.postValue(latLong)
    }

    suspend fun getCurrentWeather(coordinates: Pair<String, String>) {
        val currentWeatherDetail = getCurrentWeatherLatLongUseCase.execute(coordinates)
        val currentWeatherUiData = currentWeatherUiMapper.getUiModel(currentWeatherDetail)
        this.mCurrentWeatherUiData.postValue(currentWeatherUiData)
    }

}