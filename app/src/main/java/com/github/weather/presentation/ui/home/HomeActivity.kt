package com.github.weather.presentation.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.weather.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    val viewModel: HomeViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

}