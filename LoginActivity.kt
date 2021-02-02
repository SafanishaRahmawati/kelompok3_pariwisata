package com.example.kelompok3.activity.pengguna.misc

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.kelompok3.R
import com.example.kelompok3.activity.admin.AdminActivity
import com.android.volley.AuthFailureError
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject
import java.util.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    var etUser: EditText? = null
    var etPass: EditText? = null
    var btnLogin: Button? = null
    var btnlogin: Button? = null
    var btnEdit: Button? = null
    var pbLogin: ProgressBar? = null
    var llAdmin: LinearLayout? = null
    var ivBalek: ImageView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val actionBar = supportActionBar
        actionBar?.hide()

        etUser = findViewById(R.id.etUsername)
        etPass = findViewById(R.id.etPassword)
        //pbLogin = findViewById(R.id.pbLogin);
        btnLogin = findViewById(R.id.btnLogin)
        ivBalek = findViewById(R.id.ivBalek)
        btnlogin = findViewById(R.id.btnlogin)
        ivBalek?.setOnClickListener(this)
        btnLogin?.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v?.getId() == R.id.btnLogin) {
            val mUser = etUser?.getText().toString().trim { it <= ' ' }
            val mPass = etPass?.getText().toString().trim { it <= ' ' }
            if (!mUser.isEmpty() || !mPass.isEmpty()) {
                cekLogin(mUser, mPass)
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun cekLogin(nama: String?, password: String?) {
        //pbLogin.setVisibility(View.VISIBLE);
        btnLogin?.setVisibility(View.GONE)
        val stringRequest: StringRequest = object : StringRequest(Method.POST, URL_LOGIN,
                Response.Listener { response ->
                    try {
                        val jsonObject = JSONObject(response)
                        val succes = jsonObject.getString("success")
                        val jsonArray = jsonObject.getJSONArray("login")
                        if (succes == "1") {
                            for (i in 0 until jsonArray.length()) {
                                val `object` = jsonArray.getJSONObject(i)
                                val nama = `object`.getString("nama").trim { it <= ' ' }
                                Toast.makeText(this@LoginActivity, "Berhasil Login Sebagai $nama", Toast.LENGTH_SHORT).show()

                                btnLogin?.setVisibility(View.VISIBLE)
                                val j = Intent(this@LoginActivity, AdminActivity::class.java)
                                startActivity(j)
                                finish()
                            }
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                        Toast.makeText(this@LoginActivity, "Gagal Login, Periksa Kembali Username atau Password", Toast.LENGTH_SHORT).show()
                        //pbLogin.setVisibility(View.GONE);
                        btnLogin?.setVisibility(View.VISIBLE)
                    }
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this@LoginActivity, "Terjadi Kesalahan$error", Toast.LENGTH_SHORT).show()
                    //pbLogin.setVisibility(View.GONE);
                    btnLogin?.setVisibility(View.VISIBLE)
                }) {
            @Throws(AuthFailureError::class)
            override fun getParams(): MutableMap<String?, String?>? {
                val params: MutableMap<String?, String?> = HashMap()
                params["nama"] = nama
                params["password"] = password
                return params
            }
        }
        val requestQueue = Volley.newRequestQueue(this)
        requestQueue.add(stringRequest)
    }

    companion object {
        private val URL_LOGIN: String? = "https://suzukaze.000webhostapp.com/login.php"
    }
}