package com.example.kelompok3.activity.pengguna.restoran

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kelompok3.R
import com.bumptech.glide.Glide

class DetailRestoranActivity : AppCompatActivity() {
    var tvWisata: TextView? = null
    var tvDesc: TextView? = null
    var tvNav: TextView? = null
    var tvNOTelp: TextView? = null
    var tvEmail: TextView? = null
    var tvLokasi: TextView? = null
    var i = 0
    var imgThumb: ImageView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_restoran)
        val actionBar = supportActionBar
        actionBar?.hide()

        //menerima data
        val namaWisata = intent.extras?.getString("tvHomestay")
        val deskripsiWisata = intent.extras?.getString("tvDeskripsi")
        val thumbWisata = intent.extras?.getString("imgThumb")
        val lokasiWisata = intent.extras?.getString("tvNavigasii")
        val notelpWisata = intent.extras?.getString("notelp")
        val alamatWisata = intent.extras?.getString("alamat")
        val emailWisata = intent.extras?.getString("email")

        //inisialisasi
        tvWisata = findViewById(R.id.tvNamaDWisataRes)
        tvDesc = findViewById(R.id.tv_DDeskripsiRes)
        imgThumb = findViewById(R.id.imgDThumbRes)
        tvNav = findViewById(R.id.btnDNavigasiRes)
        tvNOTelp = findViewById(R.id.tv001Res)
        tvEmail = findViewById(R.id.tv002Res)
        tvLokasi = findViewById(R.id.tv003Res)

        //set data
        tvWisata?.setText(namaWisata)
        tvDesc?.setText(deskripsiWisata)
        tvNOTelp?.setText(notelpWisata)
        tvEmail?.setText(alamatWisata)
        tvLokasi?.setText(emailWisata)


        //gambar berupa glide
        imgThumb?.let {
            Glide.with(this).load(thumbWisata).into(it)
        }

        //navigasi
        tvNav?.setOnClickListener(View.OnClickListener {
            val geo = "google.navigation:q=$lokasiWisata"
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(geo))
            startActivity(i)
        })
    }
}