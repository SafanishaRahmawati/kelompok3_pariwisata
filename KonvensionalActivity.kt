package com.example.kelompok3.activity.pengguna.konvensional

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuInflater
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.kelompok3.R
import com.example.kelompok3.adapters.pengguna.RVKonvensional
import com.example.kelompok3.model.WisataKonvensional
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class KonvensionalActivity : AppCompatActivity() {
    var rvKonvensional: RecyclerView? = null
    private val request: JsonArrayRequest? = null
    var ubah: Button? = null
    var fabTambah: FloatingActionButton? = null
    var ref01: SwipeRefreshLayout? = null
    private var adapter: RVKonvensional? = null
    private var listKonvensional: MutableList<WisataKonvensional?>? = null
    private val URL_ViewKonvensional: String? = "https://suzukaze.000webhostapp.com/WisataKonvesional.php"

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konvensional)
        listKonvensional = ArrayList<WisataKonvensional?>()
        fabTambah = findViewById<FloatingActionButton?>(R.id.floatTambah)
        ref01 = findViewById(R.id.refresh2Konvensional)
        rvKonvensional = findViewById<RecyclerView?>(R.id.rvKonvensional)

        rvKonvensional?.setHasFixedSize(true)
        rvKonvensional?.setLayoutManager(LinearLayoutManager(this))
        rvKonvensional?.setAdapter(adapter)
        ref01?.setOnRefreshListener {
            Handler().postDelayed({
                ref01?.setRefreshing(false)
                finish()
                val x = Intent(this@KonvensionalActivity, KonvensionalActivity::class.java)
                startActivity(x)
            }, 2000)
        }
        panggilKonvensional()
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        adapter = RVKonvensional(listKonvensional)
    }

    private fun panggilKonvensional() {
        val stringRequest = StringRequest(Request.Method.GET, URL_ViewKonvensional,
                { response ->
                    try {
                        val array = JSONArray(response)
                        for (i in 0 until array.length()) {
                            val konvensional: JSONObject = array.getJSONObject(i)
                            listKonvensional?.add(WisataKonvensional(
                                    konvensional.getString("nama_wisata"),
                                    konvensional.getString("deskripsi_wisata"),
                                    konvensional.getString("thumb_wisata"),
                                    konvensional.getString("lokasi_wisata"),
                                    konvensional.getString("nomor_telfon_wisata"),
                                    konvensional.getString("alamat_wisata"),
                                    konvensional.getString("email_wisata"),
                                    konvensional.getString("id"),
                                    konvensional.getString("nonaktifkan_wisata")
                            ))
                        }
                        val rvK = RVKonvensional(this@KonvensionalActivity, listKonvensional)
                        rvKonvensional?.setAdapter(rvK)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                { Toast.makeText(this@KonvensionalActivity, "Database Tidak Terbaca", Toast.LENGTH_SHORT).show() })
        Volley.newRequestQueue(this).add<String?>(stringRequest)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = getMenuInflater()
        inflater.inflate(R.menu.menu_main, menu)
        val searchItem = menu?.findItem(R.id.search)
        val searchView = searchItem?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                adapter?.filter?.filter(newText)
                return false
            }
        })
        return true
    }
}