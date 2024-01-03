package com.ajaythakur.stayhook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import android.content.Intent
import android.widget.Toast
import android.content.pm.PackageManager
import android.Manifest


class LocationPermissionActivity : AppCompatActivity() {
    private lateinit var locationAccess: TextView
    private val LOCATION_PERMISSION_REQUEST_CODE = 123

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location_permission)

        locationAccess = findViewById(R.id.locationAccess)
        locationAccess.setOnClickListener {
            checkPermissions()
        }
    }

    private fun checkPermissions() {
        val permissionsToRequest = arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
            // Add more permissions as needed
        )

        val permissionsNotGranted = permissionsToRequest.filter {
            ActivityCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED
        }.toTypedArray()

        if (permissionsNotGranted.isNotEmpty()) {
            ActivityCompat.requestPermissions(
                this,
                permissionsNotGranted,
                LOCATION_PERMISSION_REQUEST_CODE
            )
        } else {
            // All required permissions are already granted
            Toast.makeText(this, "Permissions Granted.", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@LocationPermissionActivity, LocationActivity::class.java))
            finish() // Add this line to finish the current activity after starting the new one
        }
    }

    // Override onRequestPermissionsResult to handle the permission request response
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == LOCATION_PERMISSION_REQUEST_CODE) {
            if (grantResults.isNotEmpty() && grantResults.all { it == PackageManager.PERMISSION_GRANTED }) {
                // All requested permissions are granted
                Toast.makeText(this, "Permissions Granted.", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@LocationPermissionActivity, LocationActivity::class.java))
                finish() // Add this line to finish the current activity after starting the new one
            } else {
                // Permission denied
                Toast.makeText(this, "Permission is required!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
