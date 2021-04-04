package com.github.weather.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.weather.R
import com.github.weather.databinding.DayWeatherLineItemBinding
import com.github.weather.presentation.data.ForecastDayWeatherUiData

class OneDayWeatherRecyclerView(private var forecastDayWeatherUiDataList: List<ForecastDayWeatherUiData>) : RecyclerView.Adapter<OneDayWeatherRecyclerView.DayWeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OneDayWeatherRecyclerView.DayWeatherViewHolder {
        val binding = DayWeatherLineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayWeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: OneDayWeatherRecyclerView.DayWeatherViewHolder, position: Int) {
        holder.setUi(forecastDayWeatherUiDataList[position])
    }

    override fun getItemCount(): Int {
        return forecastDayWeatherUiDataList.size
    }

    class DayWeatherViewHolder (private val binding: DayWeatherLineItemBinding): RecyclerView.ViewHolder(binding.root){

        fun setUi(forecastDayWeatherUiData: ForecastDayWeatherUiData) {
            binding.time.text = forecastDayWeatherUiData.time
            binding.temprature.text = forecastDayWeatherUiData.temp
            Glide
                .with(binding.root.context)
                .load(forecastDayWeatherUiData.iconUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .dontAnimate()
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.icon)

            binding.temprature.text = forecastDayWeatherUiData.temp
        }

    }
}
//.centerCrop()