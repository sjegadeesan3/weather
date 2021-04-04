package com.github.weather.presentation.ui.home

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.app.ActivityCompat
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.github.weather.R
import com.github.weather.databinding.ActivityHomeBinding
import com.github.weather.presentation.util.PermissionUtil.isLocationPermissionEnabled
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(), HomeFragment.HomeFragmentCommunicator {

    private val TAG = HomeFragment::class.java.simpleName
    private val viewModel: HomeViewModel by viewModel()
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initPermission()
    }

    private fun initPermission() {
        if(isLocationPermissionEnabled()) {
            getLocationInfo()
        } else {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION),
                1)
        }
    }

    private fun getLocationInfo() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)
        fusedLocationClient.lastLocation
            .addOnSuccessListener { location ->
                viewModel.setLatitudeAndLongitude(location.latitude.toString(), location.longitude.toString())
            }
            .addOnFailureListener {
                Log.d(TAG, "Location Not received")
            }
    }

    override fun onExtendedViewClicked() {
        val fragmentContainer = binding.fragmentContainer
        fragmentContainer.findNavController().navigate(R.id.action_homeFragment_to_detailedWeatherInfoFragment)
    }

}