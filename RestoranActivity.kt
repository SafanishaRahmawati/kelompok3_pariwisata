package com.example.kelompok3.activity.pengguna.restoran

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
import com.example.kelompok3.adapters.pengguna.RVRestoran
import com.example.kelompok3.model.Restoran
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class RestoranActivity : AppCompatActivity() {
    var rvRestoran: RecyclerView? = null
    private val request: JsonArrayRequest? = null
    private var listRestoran: MutableList<Restoran?>? = null
    private var adapter: RVRestoran? = null
    var ref01: SwipeRefreshLayout? = null
    private val URL_ViewRestoran: String? = "https://suzukaze.000webhostapp.com/Restoran.php"

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restoran)
        listRestoran = ArrayList<Restoran?>()
        ref01 = findViewById(R.id.refresh1Restoran)
        rvRestoran = findViewById<RecyclerView?>(R.id.rvRestoran)

        rvRestoran?.setHasFixedSize(true)
        rvRestoran?.setLayoutManager(LinearLayoutManager(this))
        rvRestoran?.setAdapter(adapter)

        adapter = RVRestoran(listRestoran)
        ref01?.setOnRefreshListener {
            Handler().postDelayed({
                ref01?.setRefreshing(false)
                finish()
                val x = Intent(this@RestoranActivity, RestoranActivity::class.java)
                startActivity(x)
            }, 2000)
        }
        panggilRestoran()
    }

    private fun panggilRestoran() {
        val stringRequest = StringRequest(Request.Method.GET, URL_ViewRestoran,
                { response ->
                    try {
                        val array = JSONArray(response)
                        for (i in 0 until array.length()) {
                            val restoran: JSONObject = array.getJSONObject(i)
                            listRestoran?.add(Restoran(
                                    restoran.getString("nama_restoran"),
                                    restoran.getString("deskripsi_restoran"),
                                    restoran.getString("thumb_restoran"),
                                    restoran.getString("lokasi_restoran"),
                                    restoran.getString("nomor_telfon_restoran"),
                                    restoran.getString("alamat_restoran"),
                                    restoran.getString("email_restoran"),
                                    restoran.getString("nonaktifkan_restoran"),
                                    restoran.getString("id")
                            ))
                        }
                        val rvK = RVRestoran(this@RestoranActivity, listRestoran)
                        rvRestoran?.setAdapter(rvK)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                { Toast.makeText(this@RestoranActivity, "Database Tidak Terbaca", Toast.LENGTH_SHORT).show() })
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