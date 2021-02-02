package com.example.kelompok3.activity.pengguna.homestay

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
import com.example.kelompok3.adapters.pengguna.RVHomestay
import com.example.kelompok3.model.Homestay
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class HomestayActivity : AppCompatActivity() {
    var rvHomestay: RecyclerView? = null
    private val request: JsonArrayRequest? = null
    private var listHomestay: MutableList<Homestay?>? = null
    private var adapter: RVHomestay? = null
    var ref01: SwipeRefreshLayout? = null
    private val URL_ViewHomestay: String? = "https://suzukaze.000webhostapp.com/Homestay.php"

    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homestay)
        listHomestay = ArrayList<Homestay?>()
        ref01 = findViewById(R.id.refresh1Homestay)
        rvHomestay = findViewById<RecyclerView?>(R.id.rvHomestay1)

        rvHomestay?.setHasFixedSize(true)
        rvHomestay?.setLayoutManager(LinearLayoutManager(this))
        rvHomestay?.setAdapter(adapter)
        adapter = RVHomestay(listHomestay)

        ref01?.setOnRefreshListener {
            Handler().postDelayed({
                ref01?.setRefreshing(false)
                finish()
                val x = Intent(this@HomestayActivity, HomestayActivity::class.java)
                startActivity(x)
            }, 2000)
        }
        panggilHomestay()
    }

    private fun panggilHomestay() {
        val stringRequest = StringRequest(Request.Method.GET, URL_ViewHomestay,
                { response ->
                    try {
                        val array = JSONArray(response)
                        for (i in 0 until array.length()) {
                            val homestay: JSONObject = array.getJSONObject(i)
                            listHomestay?.add(Homestay(
                                    homestay.getString("nama_homestay"),
                                    homestay.getString("deskripsi_homestay"),
                                    homestay.getString("thumb_homestay"),
                                    homestay.getString("lokasi_homestay"),
                                    homestay.getString("nomor_telfon_homestay"),
                                    homestay.getString("alamat_homestay"),
                                    homestay.getString("email_homestay"),
                                    homestay.getString("nonaktifkan_homestay"),
                                    homestay.getString("id")
                            ))
                        }
                        val rvH = RVHomestay(this@HomestayActivity, listHomestay)
                        rvHomestay?.setAdapter(rvH)
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                { Toast.makeText(this@HomestayActivity, "Database Tidak Terbaca", Toast.LENGTH_SHORT).show() })
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