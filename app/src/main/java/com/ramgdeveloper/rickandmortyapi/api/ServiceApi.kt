package com.ramgdeveloper.rickandmortyapi.api

import com.ramgdeveloper.rickandmortyapi.model.RickMortyNetworkEntity
import retrofit2.http.GET

interface ServiceApi {

    @GET("api/character")
    fun getApiData (): RickMortyNetworkEntity

}