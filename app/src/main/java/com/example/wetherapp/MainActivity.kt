package com.example.wetherapp

import android.app.DownloadManager
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.wetherapp.databinding.ActivityMainBinding
import com.example.wetherapp.fragments.MainFragment
import org.json.JSONObject

const val API_KEY = "89bb3f07d2d044ca84953608242109"
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager.beginTransaction().replace(R.id.main, MainFragment.newInstance())
        binding.bGet.setOnClickListener{
            getResult("London")
        }
    }
    private fun getResult(name: String){
        val url = "https://api.weatherapi.com/v1/current.json" +
                "?key=$API_KEY &q=$name&aqi=no"
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,
            url,
            {
                respounce->
                val obj = JSONObject(respounce)
                val temp = obj.getJSONObject("current")
                Log.d("MyLog", "Respounce: ${temp.getString("temp_c")}")
            },
            {
                Log.d("MyLog", "Volley errors:$it")
            }
            )
        queue.add(stringRequest)
    }
}