package com.example.ud03_1_secretapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ud03_1_secretapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}