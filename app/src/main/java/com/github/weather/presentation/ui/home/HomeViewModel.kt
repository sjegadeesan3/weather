package com.github.weather.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val mLatitudeAndLongitude: MutableLiveData<Pair<Double, Double>> = MutableLiveData()
    val latitudeAndLongitude: LiveData<Pair<Double, Double>>
        get() = mLatitudeAndLongitude


    fun setLatitudeAndLongitude(latitude: Double, longitude: Double) {
        val latLong = Pair(latitude, longitude)
        mLatitudeAndLongitude.postValue(latLong)
    }

}