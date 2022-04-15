package com.play.eg.navigationcomponent.bottomnavigationview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.play.eg.navigationcomponent.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val bottomNavigationView:BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navController = findNavController(R.id.navHostFragment2)

        val appBarConfiguration = AppBarConfiguration(setOf(R.id.firstFragment2,R.id.secondFragment2,R.id.ThirdFragment))
        setupActionBarWithNavController(navController,appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)
    }
}