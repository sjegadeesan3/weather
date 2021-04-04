package com.github.weather.presentation.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.github.weather.R
import com.github.weather.databinding.DateWiseWeatherLineItemBinding
import com.github.weather.presentation.data.DateWiseWeatherUiData

class DateWiseWeatherRecyclerView(private var dateWiseWeatherUiDataList: List<DateWiseWeatherUiData>,
private val clickListener: (Long) -> Unit) : RecyclerView.Adapter<DateWiseWeatherRecyclerView.DayWeatherViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayWeatherViewHolder {
        val binding = DateWiseWeatherLineItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DayWeatherViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DayWeatherViewHolder, position: Int) {
        holder.setUi(dateWiseWeatherUiDataList[position], clickListener)
    }

    override fun getItemCount(): Int {
        return dateWiseWeatherUiDataList.size
    }

    class DayWeatherViewHolder (private val binding: DateWiseWeatherLineItemBinding): RecyclerView.ViewHolder(binding.root){

        fun setUi(dateWiseWeatherUiData: DateWiseWeatherUiData, clickListener: (Long) -> Unit) {
            binding.date.text = dateWiseWeatherUiData.time
            Glide
                .with(binding.root.context)
                .load(dateWiseWeatherUiData.icon)
                .placeholder(R.drawable.ic_launcher_background)
                .dontAnimate()
                .error(R.drawable.ic_launcher_foreground)
                .into(binding.weatherIcon)

            binding.lineItem.setOnClickListener {
                clickListener(dateWiseWeatherUiData.timeStamp)
            }
        }
    }
}