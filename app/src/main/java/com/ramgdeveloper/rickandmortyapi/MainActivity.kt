package com.ramgdeveloper.rickandmortyapi

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.ramgdeveloper.rickandmortyapi.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy{
        RickMortyAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        getResponse()

        binding.button.setOnClickListener {

            binding.button.isVisible = false
            binding.textView.isVisible = false
            binding.progressBar2.isVisible = true

            getResponse()
        }



    }

    private fun getResponse(){
        RickMortyApi.retrofitService.getRickMorty().enqueue(object: Callback<RickMorty>{
            override fun onFailure(call: Call<RickMorty>, t: Throwable) {
                Timber.d(t.localizedMessage)
                binding.progressBar2.isVisible = false
                binding.textView.text = t.localizedMessage
                binding.textView.isVisible = true

                binding.button.isVisible = true
            }

            override fun onResponse(call: Call<RickMorty>, response: Response<RickMorty>) {
                Timber.d(response.body()?.results?.get(0)?.name)
                adapter.submitList(response.body()!!.results)
                binding.recyclerview.adapter = adapter

                binding.progressBar2.isVisible = false
            }

        })
    }
}
