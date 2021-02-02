package com.example.kelompok3.activity.pengguna.misc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kelompok3.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val actionBar = supportActionBar
        actionBar?.hide()
    }
}