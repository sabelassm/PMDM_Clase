package com.example.ud01_3chronos

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.Chronometer
import com.example.ud01_3chronos.databinding.ActivityMainBinding
import java.nio.file.Files

class MainActivity : AppCompatActivity() {
    lateinit var chrono: Chronometer
    var running = false
    var offset = 0L
    val RUNNING_KEY = "running"
    val OFFSET_KEY ="offset"
    val BASE_KEY = "base"

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if(savedInstanceState!=null){
            offset = savedInstanceState.getLong(OFFSET_KEY)
            running = savedInstanceState.getBoolean(RUNNING_KEY)

            if(running){
                binding.chrono.base = savedInstanceState.getLong(BASE_KEY)
                binding.chrono.start()
            }else{
                binding.chrono.base = SystemClock.elapsedRealtime() - offset
            }
        }
        binding.btnStart.setOnClickListener {
            if(!running) {
                binding.chrono.base = SystemClock.elapsedRealtime() - offset
                binding.chrono.start()
                running = true
            }
        }

        binding.btnPause.setOnClickListener {
            if(running){
                offset = SystemClock.elapsedRealtime() - binding.chrono.base
                binding.chrono.stop()
                running = false
            }
        }

        binding.btnRestart.setOnClickListener {
            offset = 0L
            binding.chrono.base = SystemClock.elapsedRealtime()
        }
    }
/*
    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(RUNNING_KEY, running)
        outState.putLong(OFFSET_KEY, offset)
        outState.putLong(BASE_KEY, chrono.base)
        super.onSaveInstanceState(outState)
    }

    override fun onStop() {
        if(running){
            offset = SystemClock.elapsedRealtime() - chrono.base
            chrono.stop()
        }
        super.onStop()
    }

    override fun onRestart() {
        if(running){
            chrono.base = SystemClock.elapsedRealtime() - offset
            chrono.start()
        }
        super.onRestart()
    }

    override fun onPause() {
        if(running){
            offset = SystemClock.elapsedRealtime() - chrono.base
            chrono.stop()
        }
        super.onPause()
    }

    override fun onResume() {
        if(running){
            chrono.base = SystemClock.elapsedRealtime() - offset
            chrono.start()
        }
        super.onResume()
    }
*/

}