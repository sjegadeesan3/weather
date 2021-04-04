package com.github.weather.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val mLatitudeAndLongitude: MutableLiveData<Pair<String, String>> = MutableLiveData()
    val latitudeAndLongitude: LiveData<Pair<String, String>>
        get() = mLatitudeAndLongitude


    fun setLatitudeAndLongitude(latitude: String, longitude: String) {
        val latLong = Pair(latitude, longitude)
        mLatitudeAndLongitude.postValue(latLong)
    }

}