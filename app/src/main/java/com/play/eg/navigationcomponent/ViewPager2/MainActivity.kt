package com.play.eg.navigationcomponent.ViewPager2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.play.eg.navigationcomponent.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        supportActionBar?.hide()
    }
}