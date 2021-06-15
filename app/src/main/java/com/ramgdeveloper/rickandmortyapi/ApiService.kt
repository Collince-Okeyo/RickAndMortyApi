package com.ramgdeveloper.rickandmortyapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {

    @GET("api/character")
    fun getRickMorty(): Call<List<RickMorty>>

}

object RickMortyApi{
    private const val BASE_URL = "https://rickandmortyapi.com/"

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val retrofitService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}