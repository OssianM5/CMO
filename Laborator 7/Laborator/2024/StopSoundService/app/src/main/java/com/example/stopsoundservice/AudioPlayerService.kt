package com.example.stopsoundservice

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log

class AudioPlayerService : Service() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.example).apply {
            isLooping = false // Nu repeta automat
        }
        Log.d("AudioPlayerService", "Service creat")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val action = intent?.getStringExtra("ACTION")
        when (action) {
            "PLAY" -> {
                if (mediaPlayer?.isPlaying == false) {
                    mediaPlayer?.start()
                    Log.d("AudioPlayerService", "Redare începută")
                }
            }
            "PAUSE" -> {
                if (mediaPlayer?.isPlaying == true) {
                    mediaPlayer?.pause()
                    Log.d("AudioPlayerService", "Redare pauzată")
                }
            }
            "STOP" -> {
                mediaPlayer?.stop()
                mediaPlayer?.reset()
                mediaPlayer = MediaPlayer.create(this, R.raw.example)
                Log.d("AudioPlayerService", "Redare oprită")
            }
        }
        return START_STICKY // Continuă să ruleze dacă aplicația este închisă
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer?.release()
        mediaPlayer = null
        Log.d("AudioPlayerService", "Service distrus")
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null // Nu folosim legarea cu activitatea
    }
}
