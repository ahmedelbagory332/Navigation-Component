package com.play.eg.navigationcomponent.NavigationDrawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.play.eg.navigationcomponent.R

import androidx.annotation.NonNull




class MainActivity : AppCompatActivity() {
    lateinit var navController: NavController
    lateinit var drawerLayout: DrawerLayout
    lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var navigationView: NavigationView
    lateinit var listener: NavController.OnDestinationChangedListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navController = findNavController(R.id.host_container)
        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)
        appBarConfiguration = AppBarConfiguration(navController.graph,drawerLayout)

        setSupportActionBar(findViewById(R.id.toolbar))

        navigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController,appBarConfiguration)




        listener = NavController.OnDestinationChangedListener { controller, destination, arguments ->
            when {
                destination.id == R.id.firstFragment -> {
                    drawerLayout.close()
                }
                destination.id == R.id.secondFragment -> {
                    Toast.makeText(this,"second",Toast.LENGTH_LONG).show()
                }
                drawerLayout.isDrawerOpen(GravityCompat.START) -> {
                    drawerLayout.closeDrawer(GravityCompat.START)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }


    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(listener)
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(listener)

    }
}