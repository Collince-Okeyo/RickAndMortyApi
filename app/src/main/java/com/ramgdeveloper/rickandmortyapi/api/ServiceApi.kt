package com.ramgdeveloper.rickandmortyapi.api

import com.ramgdeveloper.rickandmortyapi.model.RickMortyData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.GET

const val BASE_URL = "https://rickandmortyapi.com/"
interface ServiceApi {

    @GET("api/character")
    fun getNetworkData(): Call<List<RickMortyData>>

}

val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

object RickMortyApi{
    val retrofitService: ServiceApi by lazy {
        retrofit.create(ServiceApi::class.java)
    }
}