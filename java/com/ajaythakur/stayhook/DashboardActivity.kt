package com.ajaythakur.stayhook

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.project.stayhook.account.AccountFragment

class DashboardActivity : AppCompatActivity() {
    lateinit var bottomNavigationBar: com.google.android.material.bottomnavigation.BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        bottomNavigationBar = findViewById(R.id.navigation_bar)
        supportFragmentManager.beginTransaction().replace(R.id.DashboardFragment, HomeFragment()).commit()

        // Set a listener for item selection events
        bottomNavigationBar.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.HomeTab -> {
                    // Replace the fragment or launch the activity for Home
                    supportFragmentManager.beginTransaction().replace(
                        R.id.DashboardFragment,
                        HomeFragment()
                    ).commit()
                    true
                }
                R.id.SearchTab -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.DashboardFragment,
                        SearchFragment()
                    ).commit()
                    true
                }
                R.id.SettingsTab -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.DashboardFragment,
                        SettingsFragment()
                    ).commit()
                    true
                }
                R.id.AccountTab -> {
                    supportFragmentManager.beginTransaction().replace(
                        R.id.DashboardFragment,
                        AccountFragment()
                    ).commit()
                    true
                }
                else -> false
            }
        }
    }
}
