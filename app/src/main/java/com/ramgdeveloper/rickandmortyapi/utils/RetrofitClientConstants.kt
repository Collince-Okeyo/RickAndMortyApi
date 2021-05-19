package com.ramgdeveloper.rickandmortyapi.utils

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClientConstants {

     private val BASE_URL: String = "https://rickandmortyapi.com/"

    val retrofit = Retrofit.Builder().
            baseUrl(BASE_URL).
            addConverterFactory(GsonConverterFactory.create()).
            build()


}