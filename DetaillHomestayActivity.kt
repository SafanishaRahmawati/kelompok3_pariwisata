package com.example.kelompok3.activity.pengguna.homestay

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kelompok3.R
import com.bumptech.glide.Glide
import java.math.BigInteger

class DetaillHomestayActivity : AppCompatActivity() {
    var tvWisata: TextView? = null
    var tvDesc: TextView? = null
    var tvNav: TextView? = null
    var tvNoTelp: TextView? = null
    var tvEmail: TextView? = null
    var tvLokasi: TextView? = null
    var tvDial: TextView? = null
    var tvisiDial: TextView? = null
    var imgThumb: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detaill_homestay)
        supportActionBar?.hide()

        //menerima data
        val namaWisata = intent.extras?.getString("tvHomestayH")
        val deskripsiWisata = intent.extras?.getString("tvDeskripsiH")
        val thumbWisata = intent.extras?.getString("imgThumbH")
        val lokasiWisata = intent.extras?.getString("tvNavigasiiH")
        val notelpWisata = intent.extras?.getString("notelpH")
        val alamatWisata = intent.extras?.getString("alamatH")
        val emailWisata = intent.extras?.getString("emailH")

        //inisialisasi
        tvWisata = findViewById(R.id.tvNamaDWisataH)
        tvDesc = findViewById(R.id.tv_DDeskripsiH)
        imgThumb = findViewById(R.id.imgDThumbH)
        tvNav = findViewById(R.id.btnDNavigasiH)
        tvNoTelp = findViewById(R.id.tv001H)
        tvEmail = findViewById(R.id.tv002H)
        tvLokasi = findViewById(R.id.tv003H)
        tvDial = findViewById(R.id.btnTelpH)
        tvisiDial = findViewById(R.id.tel)

        //set data
        tvWisata?.setText(namaWisata)
        tvDesc?.setText(deskripsiWisata)
        tvNoTelp?.setText(notelpWisata)
        tvEmail?.setText(alamatWisata)
        tvLokasi?.setText(emailWisata)
        tvisiDial?.setText(notelpWisata)

        imgThumb?.let {
            Glide.with(this).load(thumbWisata).into(it)
        }

        //navigasi
        tvNav?.setOnClickListener(View.OnClickListener {
            val geo = "google.navigation:q=$lokasiWisata"
            val i = Intent(Intent.ACTION_VIEW, Uri.parse(geo))
            startActivity(i)
        })
        tvDial?.setOnClickListener(View.OnClickListener {
            val myNum = BigInteger(notelpWisata)
            val tel = "tel:0$myNum"
            val j = Intent(Intent.ACTION_DIAL, Uri.parse(tel))
            startActivity(j)
        })
    }
}