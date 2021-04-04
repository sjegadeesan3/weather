package com.github.weather.presentation.util

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import androidx.core.app.ActivityCompat

object PermissionUtil {

    fun Activity.isLocationPermissionEnabled() : Boolean {
        return isAccessFineLocationGranted() && isAccessCoarseLocationGranted()
    }

    private fun Context.isAccessFineLocationGranted() =
        ActivityCompat.checkSelfPermission(this.applicationContext, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED

    private fun Context.isAccessCoarseLocationGranted() =
        ActivityCompat.checkSelfPermission(this.applicationContext, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED
}