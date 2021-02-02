package com.example.kelompok3.activity.pengguna.religi

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuInflater
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.kelompok3.R
import com.example.kelompok3.adapters.pengguna.RVReligi
import com.example.kelompok3.model.WisataReligi
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class ReligiActivity : AppCompatActivity() {
    var rvReligi: RecyclerView? = null
    private val request: JsonArrayRequest? = null
    private var listReligi: MutableList<WisataReligi?>? = null
    private var adapter: RVReligi? = null
    var ref01: SwipeRefreshLayout? = null
    private val URL_ViewReligi: String? = "https://suzukaze.000webhostapp.com/WisataReligi.php"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_religi)
        listReligi = ArrayList<WisataReligi?>()
        ref01 = findViewById(R.id.refresh1Religi)
        rvReligi = findViewById<RecyclerView?>(R.id.rvReligi)

        rvReligi?.setHasFixedSize(true)
        rvReligi?.setLayoutManager(LinearLayoutManager(this))
        rvReligi?.setAdapter(adapter)

        adapter = RVReligi(listReligi)
        ref01?.setOnRefreshListener {
            Handler().postDelayed({
                ref01?.setRefreshing(false)
                finish()
                val x = Intent(this@ReligiActivity, ReligiActivity::class.java)
                startActivity(x)
            }, 2000)
        }
        panggilReligi()
    }

    private fun panggilReligi() {
        val stringRequest = StringRequest(Request.Method.GET, URL_ViewReligi,
                { response ->
                    try {
                        val array = JSONArray(response)
                        for (i in 0 until array.length()) {
                            val religi: JSONObject = array.getJSONObject(i)
                            listReligi?.add(WisataReligi(
                                    religi.getString("nama_wisata"),
                                    religi.getString("deskripsi_wisata"),
                                    religi.getString("thumb_wisata"),
                                    religi.getString("lokasi_wisata"),
                                    religi.getString("nomor_telfon_wisata"),
                                    religi.getString("alamat_wisata"),
                                    religi.getString("email_wisata"),
                                    religi.getString("nonaktifkan_wisata"),
                                    religi.getString("id")
                            ))
                        }
                        val rvK = RVReligi(this@ReligiActivity, listReligi)
                        rvReligi?.setAdapter(rvK)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                { Toast.makeText(this@ReligiActivity, "Database Tidak Terbaca", Toast.LENGTH_SHORT).show() })
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
                adapter?.getFilter()?.filter(newText)
                return false
            }
        })
        return true
    }
}