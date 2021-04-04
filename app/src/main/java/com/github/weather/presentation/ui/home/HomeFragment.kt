package com.github.weather.presentation.ui.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.github.weather.R
import com.github.weather.domain.usecase.current.GetCurrentWeatherLatLongUseCase
import com.github.weather.domain.usecase.forecast.GetForecastWeatherLatLongUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by sharedViewModel()
    private val getCurrentWeatherLatLongUseCase: GetCurrentWeatherLatLongUseCase by inject()
    private val getForecastWeatherLatLongUseCase: GetForecastWeatherLatLongUseCase by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.latitudeAndLongitude.observe(requireActivity(), { coordinates ->
            lifecycleScope.launch(Dispatchers.IO) {
                val currentWeatherDetail = getCurrentWeatherLatLongUseCase.execute(coordinates)
                Log.d("TestCurrent", "${currentWeatherDetail?.main?.temp}")
            }

            lifecycleScope.launch(Dispatchers.IO) {
                val currentWeatherDetail = getForecastWeatherLatLongUseCase.execute(coordinates)
                Log.d("TestCurrent", "${currentWeatherDetail?.city?.country}")
            }
        })
    }

}