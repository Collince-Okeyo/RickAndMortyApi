package com.ramgdeveloper.rickandmortyapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("api/character")
    fun getRickMorty(): Call<List<RickMorty.Result>>

}

object RickMortyApi{
    const val BASE_URL = "https://rickandmortyapi.com/"

    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService by lazy {
        retrofit.create(ApiService::class.java)
    }
}