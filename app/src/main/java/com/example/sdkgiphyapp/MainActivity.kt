package com.example.sdkgiphyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sdkgiphyapp.databinding.ActivityMainBinding
import com.example.sdkgiphyapp.model.CharacterResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {

    private lateinit var binding: ActivityMainBinding
    private var API_KEY: String = "a83286769ce970c96385ca2a48f68116"
    private var HASH: String = "d1c9bd7c00e9a01c64d5167101447618"
    private lateinit var adapter: CharacterAdapter
    private val marvelNames = mutableListOf<Character>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svCharacters.setOnQueryTextListener(this)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        adapter = CharacterAdapter(marvelNames)
        binding.rvMarvel.layoutManager = LinearLayoutManager(this)
        binding.rvMarvel.adapter = adapter

    }

    private fun getRetroFit():Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://gateway.marvel.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun searchByName(query:String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call: Response<CharacterResponse> = getRetroFit().create(ApiService::class.java)
                .getCharacters("/v1/public/characters?" + "ts=1&apikey=" + API_KEY + "&hash=" + HASH)
            val characters : List<Character>? = call.body()?.data?.results
            runOnUiThread {
                if(call.isSuccessful) {
                    marvelNames.clear()
                    if (characters != null) {
                        marvelNames.addAll(characters)
                        adapter.notifyDataSetChanged()
                    }
                } else {
                    showError()
                }
            }

        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()){
            searchByName(query.lowercase(Locale.getDefault()))
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        return true
    }
}