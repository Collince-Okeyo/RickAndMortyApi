package com.ramgdeveloper.rickandmortyapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.ramgdeveloper.rickandmortyapi.api.RickMortyApi
import com.ramgdeveloper.rickandmortyapi.databinding.ActivityMainBinding
import com.ramgdeveloper.rickandmortyapi.model.RickMortyData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: RecyclerAdapter
    private val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = RecyclerAdapter()
        RickMortyApi.retrofitService.getNetworkData().enqueue(object: Callback<List<RickMortyData>> {
            override fun onResponse(call: Call<List<RickMortyData>>, response: Response<List<RickMortyData>>) {
                adapter.submitList(response.body())
                binding.recyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<List<RickMortyData>>, t: Throwable) {
                Log.d(TAG, "onFailure: ${t.message}")
            }
        })
    }
}
