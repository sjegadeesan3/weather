package com.github.weather.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.weather.R
import com.github.weather.databinding.HomeFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: HomeFragmentBinding
    private val viewModel: HomeViewModel by sharedViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initView()
        viewModel.latitudeAndLongitude.observe(requireActivity(), { coordinates ->
            //Get current and forecast weather info simultaneously
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.getCurrentWeather(coordinates)
            }
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.getForecastWeather(coordinates)
            }
        })

        viewModel.forecastDayWeatherUiData.observe(requireActivity(), Observer { list ->
            list?.let {
                binding.dayWeatherRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                binding.dayWeatherRecyclerView.adapter = OneDayWeatherRecyclerView(it.take(20))
            }
        })

    }



    private fun initView() {
        binding.extendedView.setOnClickListener {
            if (requireActivity() is HomeFragmentCommunicator) {
                (requireActivity() as HomeFragmentCommunicator)?.apply {
                    onExtendedViewClicked()
                }
            }
        }
    }

    interface HomeFragmentCommunicator {
        fun onExtendedViewClicked()
    }

}
