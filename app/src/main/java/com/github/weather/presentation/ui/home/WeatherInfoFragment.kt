package com.github.weather.presentation.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.weather.R
import com.github.weather.databinding.FragmentWeatherInfoBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class WeatherInfoFragment : Fragment() {

    private val viewModel: HomeViewModel by sharedViewModel()
    lateinit var binding: FragmentWeatherInfoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather_info, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getWeatherInfo()
        viewModel.weatherInfoUiData.observe(requireActivity(), Observer {
            it?.let {
                val layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)

                binding.weatherInfoRecyclerView.layoutManager = layoutManager
                binding.weatherInfoRecyclerView.adapter = WeatherInfoRecyclerView(it)
                val dividerItemDecoration = DividerItemDecoration(binding.weatherInfoRecyclerView.context, layoutManager.orientation)
                binding.weatherInfoRecyclerView.addItemDecoration(dividerItemDecoration)
            }
        })
    }
}