package com.example.kelompok3.activity.pengguna.misc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.kelompok3.R
import com.example.kelompok3.activity.pengguna.konvensional.KonvensionalActivity
import com.example.kelompok3.activity.pengguna.religi.ReligiActivity

class TempatWisataActivity : AppCompatActivity() {
    var ll01: LinearLayout? = null
    var ll02: LinearLayout? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tempat_wisata)
        val actionBar = supportActionBar
        actionBar?.hide()
        ll01 = findViewById(R.id.llKonvensional)
        ll02 = findViewById(R.id.llReligi)
        ll01?.setOnClickListener(View.OnClickListener {
            val k = Intent(this@TempatWisataActivity, KonvensionalActivity::class.java)
            startActivity(k)
        })
        ll02?.setOnClickListener(View.OnClickListener {
            val h = Intent(this@TempatWisataActivity, ReligiActivity::class.java)
            startActivity(h)
        })
    }
}