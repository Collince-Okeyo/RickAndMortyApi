package com.ramgdeveloper.rickandmortyapi.model

import com.google.gson.annotations.SerializedName

class RickMortyNetworkEntity (
    @SerializedName("name")
    var name: String? = null,

    @SerializedName("status")
    var status: String? = null,

    @SerializedName("species")
    var species: String? = null,

    @SerializedName("image")
    var image: String? = null
)