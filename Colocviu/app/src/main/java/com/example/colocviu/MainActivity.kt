package com.example.colocviu

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.colocviu.ui.fragments.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Afișează primul fragment (SearchFragment)
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, SearchFragment())
            .commit()
    }
}
