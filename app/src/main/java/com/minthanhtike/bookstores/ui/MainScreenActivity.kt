package com.minthanhtike.bookstores.ui

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.minthanhtike.bookstores.R
import com.minthanhtike.bookstores.databinding.ActivityMainBinding

class MainScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController by lazy {
            val navHostFragment = supportFragmentManager
                .findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment

            navHostFragment.navController
        }
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        navView.setupWithNavController(navController)
    }

}