package com.ramgdeveloper.rickandmortyapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ramgdeveloper.rickandmortyapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        RickMortyApi.retrofitService.getRickMorty().enqueue(object : Callback<List<RickMorty>>{
            override fun onFailure(call: Call<List<RickMorty>>, t: Throwable) {
                Timber.d(t.localizedMessage)
            }

            override fun onResponse(
                call: Call<List<RickMorty>>,
                response: Response<List<RickMorty>>
            ) {
                Timber.d(response.body()?.get(0)?.results?.get(0)?.name)
            }

        })

    }
}
