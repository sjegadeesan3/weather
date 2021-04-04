package com.github.weather.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.weather.data.model.CurrentWeatherDetail

class HomeViewModel : ViewModel() {

    private val mLatitudeAndLongitude: MutableLiveData<Pair<String, String>> = MutableLiveData()
    val latitudeAndLongitude: LiveData<Pair<String, String>>
        get() = mLatitudeAndLongitude


    private val mCurrentWeatherDetail: MutableLiveData<CurrentWeatherDetail?> = MutableLiveData()
    val currentWeatherDetail: LiveData<CurrentWeatherDetail?>
        get() = mCurrentWeatherDetail


    var aa: CurrentWeatherDetail? = null


    fun setLatitudeAndLongitude(latitude: String, longitude: String) {
        val latLong = Pair(latitude, longitude)
        mLatitudeAndLongitude.postValue(latLong)
    }

    fun setCurrentWeatherDetail(currentWeatherDetail: CurrentWeatherDetail?) {
        this.mCurrentWeatherDetail.postValue(currentWeatherDetail)
        aa = currentWeatherDetail
    }

}