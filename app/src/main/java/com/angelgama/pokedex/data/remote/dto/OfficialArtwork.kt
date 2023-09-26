package com.angelgama.pokedex.data.remote.dto

import com.google.gson.annotations.SerializedName

data class OfficialArtwork(
    @SerializedName("front_default")
    val frontDefault: String,
    val front_shiny: String
)