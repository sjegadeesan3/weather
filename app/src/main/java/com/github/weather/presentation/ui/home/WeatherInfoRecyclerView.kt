package com.github.weather.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.github.weather.databinding.WeatherInfoLineItemBinding

class WeatherInfoRecyclerView(private var weatherInfoUiData: List<Pair<String, String>>) : RecyclerView.Adapter<WeatherInfoRecyclerView.WeatherInfoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherInfoViewHolder {
        val binding = WeatherInfoLineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherInfoViewHolder(binding)
    }

    override fun onBindViewHolder(holderInfo: WeatherInfoViewHolder, position: Int) {
        holderInfo.setUi(weatherInfoUiData[position])
    }

    override fun getItemCount(): Int {
        return weatherInfoUiData.size
    }

    class WeatherInfoViewHolder (private val binding: WeatherInfoLineItemBinding): RecyclerView.ViewHolder(binding.root){

        fun setUi(pair: Pair<String, String>) {
            binding.label.text = pair.first
            binding.value.text = pair.second
        }
    }
}