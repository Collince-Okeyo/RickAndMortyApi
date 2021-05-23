package com.ramgdeveloper.rickandmortyapi.model

import com.google.gson.annotations.SerializedName
import retrofit2.Call
import retrofit2.http.GET

class RickMortyData (
    @SerializedName("id")
    var id: Int? = null,

    @SerializedName("name")
    var name: String? = null,

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("species")
    var species: String? = null,

    @SerializedName("image")
    var image: String? = null
)
