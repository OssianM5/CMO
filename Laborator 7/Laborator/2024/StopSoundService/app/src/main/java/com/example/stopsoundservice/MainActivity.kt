package com.example.stopsoundservice

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.stopsoundservice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnPlay.setOnClickListener {
            controlService("PLAY")
        }

        binding.btnPause.setOnClickListener {
            controlService("PAUSE")
        }

        binding.btnStop.setOnClickListener {
            controlService("STOP")
        }
    }

    private fun controlService(action: String) {
        val intent = Intent(this, AudioPlayerService::class.java).apply {
            putExtra("ACTION", action)
        }
        startService(intent)
    }

    override fun onDestroy() {
        super.onDestroy()
        // Service-ul rămâne activ, nu îl oprim
    }
}
