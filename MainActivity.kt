package com.example.kelompok3.activity.pengguna

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import com.example.kelompok3.R
import com.example.kelompok3.activity.admin.misc.RegisterActivity
import com.example.kelompok3.activity.pengguna.homestay.HomestayActivity
import com.example.kelompok3.activity.pengguna.misc.AboutActivity
import com.example.kelompok3.activity.pengguna.misc.LoginActivity
import com.example.kelompok3.activity.pengguna.misc.TempatWisataActivity
import com.example.kelompok3.activity.pengguna.restoran.RestoranActivity
import de.hdodenhof.circleimageview.CircleImageView

class MainActivity : AppCompatActivity() {
    var lladmin: LinearLayout? = null
    var llWisata: LinearLayout? = null
    var llAbout: LinearLayout? = null
    var llHomestay: LinearLayout? = null
    var llRestoran: LinearLayout? = null
    var cvLogout: CardView? = null
    var btnLogin: Button? = null
    var ci1: CircleImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val actionBar = supportActionBar
        actionBar?.hide()
        ci1 = findViewById(R.id.img1)
        btnLogin = findViewById(R.id.btnlogin)
        llWisata = findViewById(R.id.llWisata)
        llAbout = findViewById(R.id.llAbout)
        llHomestay = findViewById(R.id.llHomestay)
        llRestoran = findViewById(R.id.llRestoran)
        ci1?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@MainActivity, RegisterActivity::class.java)
            startActivity(i)
        })
        btnLogin?.setOnClickListener(View.OnClickListener { showLogin() })
        llWisata?.setOnClickListener(View.OnClickListener { showWisata() })
        llAbout?.setOnClickListener(View.OnClickListener { showAbout() })
        llHomestay?.setOnClickListener(View.OnClickListener { showHomestay() })
        llRestoran?.setOnClickListener(View.OnClickListener { showRestoran() })
    }

    private fun showRestoran() {
        val restoran = Intent(this@MainActivity, RestoranActivity::class.java)
        startActivity(restoran)
    }

    private fun showHomestay() {
        val homestay = Intent(this@MainActivity, HomestayActivity::class.java)
        startActivity(homestay)
    }

    private fun showAbout() {
        val about = Intent(this@MainActivity, AboutActivity::class.java)
        startActivity(about)
    }

    private fun showWisata() {
        val wisata = Intent(this@MainActivity, TempatWisataActivity::class.java)
        startActivity(wisata)
    }

    private fun showLogin() {
        val showLogin = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(showLogin)
    }
}