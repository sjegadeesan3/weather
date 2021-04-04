package com.github.weather.presentation.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.weather.data.model.ForecastWeatherDetail
import com.github.weather.domain.usecase.current.GetCurrentWeatherLatLongUseCase
import com.github.weather.domain.usecase.forecast.GetForecastWeatherLatLongUseCase
import com.github.weather.presentation.data.CurrentWeatherUiData
import com.github.weather.presentation.data.DateWiseWeatherUiData
import com.github.weather.presentation.data.ForecastDayWeatherUiData
import com.github.weather.presentation.mapper.CurrentWeatherUiMapper
import com.github.weather.presentation.mapper.DateWiseWeatherUiMapper
import com.github.weather.presentation.mapper.ForecastDayWeatherUiMapper
import com.github.weather.presentation.mapper.WeatherInfoUiMapper
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class HomeViewModel : ViewModel(), KoinComponent {

    private val getCurrentWeatherLatLongUseCase: GetCurrentWeatherLatLongUseCase by inject()
    private val getForecastWeatherLatLongUseCase: GetForecastWeatherLatLongUseCase by inject()
    private val currentWeatherUiMapper: CurrentWeatherUiMapper by inject()
    private val forecastDayWeatherUiMapper: ForecastDayWeatherUiMapper by inject()
    private val dateWiseWeatherUiMapper: DateWiseWeatherUiMapper by inject()
    private val weatherInfoUiMapper: WeatherInfoUiMapper by inject()

    private val mLatitudeAndLongitude: MutableLiveData<Pair<String, String>> = MutableLiveData()
    val latitudeAndLongitude: LiveData<Pair<String, String>>
        get() = mLatitudeAndLongitude

    var forecastWeatherDetail: ForecastWeatherDetail? = null
    var weatherTimeStamp: Long = 0L


    private val mCurrentWeatherUiData: MutableLiveData<CurrentWeatherUiData?> = MutableLiveData()
    val currentWeatherUiData: LiveData<CurrentWeatherUiData?>
        get() = mCurrentWeatherUiData

    private val mForecastDayWeatherUiData: MutableLiveData<List<ForecastDayWeatherUiData>?> = MutableLiveData()
    val forecastDayWeatherUiData: LiveData<List<ForecastDayWeatherUiData>?>
        get() = mForecastDayWeatherUiData

    private val mDateWiseWeatherUiData: MutableLiveData<List<DateWiseWeatherUiData>?> = MutableLiveData()
    val dateWiseWeatherUiData: LiveData<List<DateWiseWeatherUiData>?>
        get() = mDateWiseWeatherUiData


    private val mWeatherInfoUiData: MutableLiveData<List<Pair<String, String>>?> = MutableLiveData()
    val weatherInfoUiData: LiveData<List<Pair<String, String>>?>
        get() = mWeatherInfoUiData


    fun setLatitudeAndLongitude(latitude: String, longitude: String) {
        val latLong = Pair(latitude, longitude)
        mLatitudeAndLongitude.postValue(latLong)
    }

    suspend fun getCurrentWeather(coordinates: Pair<String, String>) {
        val currentWeatherDetail = getCurrentWeatherLatLongUseCase.execute(coordinates)
        val currentWeatherUiData = currentWeatherUiMapper.getUiModel(currentWeatherDetail)
        this.mCurrentWeatherUiData.postValue(currentWeatherUiData)
    }

    suspend fun getOneDayWeatherForecast(coordinates: Pair<String, String>) {
        if(forecastWeatherDetail == null) {
            forecastWeatherDetail = getForecastWeatherLatLongUseCase.execute(coordinates)
        }
        val forecastWeatherUiData = forecastDayWeatherUiMapper.getUiModel(forecastWeatherDetail, 8)
        this.mForecastDayWeatherUiData.postValue(forecastWeatherUiData)
    }

    suspend fun getDateWiseWeatherForecast(coordinates: Pair<String, String>) {
        if(forecastWeatherDetail == null) {
            forecastWeatherDetail = getForecastWeatherLatLongUseCase.execute(coordinates)
        }
        val dateWiseWeatherUiData = dateWiseWeatherUiMapper.getUiModel(forecastWeatherDetail)
        this.mDateWiseWeatherUiData.postValue(dateWiseWeatherUiData)
    }

    fun getWeatherInfo() {
        if(forecastWeatherDetail != null && weatherTimeStamp != 0L) {
            val weatherInfoUiData = weatherInfoUiMapper.getUiModel(forecastWeatherDetail, weatherTimeStamp)
            this.mWeatherInfoUiData.postValue(weatherInfoUiData)
        }
    }

}