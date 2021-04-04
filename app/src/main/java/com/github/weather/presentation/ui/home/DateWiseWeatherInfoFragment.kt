package com.github.weather.presentation.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.weather.R
import com.github.weather.databinding.DateWiseWeatherInfoFragmentBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


class DateWiseWeatherInfoFragment : Fragment() {

    private val viewModel: HomeViewModel by sharedViewModel()
    lateinit var binding: DateWiseWeatherInfoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.date_wise_weather_info_fragment,
            container,
            false
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.latitudeAndLongitude.observe(requireActivity(), { coordinates ->
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.getDateWiseWeatherForecast(coordinates)
            }
        })
        viewModel.dateWiseWeatherUiData.observe(requireActivity(), Observer {
            it?.let {
                val layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
                binding.dateWiseWeatherRecyclerView.layoutManager = layoutManager
                binding.dateWiseWeatherRecyclerView.adapter = DateWiseWeatherRecyclerView(it) { timeStamp: Long -> dateWiseWeatherLineItemClicked(timeStamp) }
                val dividerItemDecoration = DividerItemDecoration(binding.dateWiseWeatherRecyclerView.context, layoutManager.orientation)
                binding.dateWiseWeatherRecyclerView.addItemDecoration(dividerItemDecoration)


            }
        })
    }

    private fun dateWiseWeatherLineItemClicked(timeStamp: Long) {
        if (requireActivity() is DateWiseWeatherInfoFragmentCommunicator) {
            (requireActivity() as DateWiseWeatherInfoFragmentCommunicator)?.apply {
                onForecastLineItemClicked()
            }
        }
    }

    interface DateWiseWeatherInfoFragmentCommunicator {
        fun onForecastLineItemClicked()
    }
}