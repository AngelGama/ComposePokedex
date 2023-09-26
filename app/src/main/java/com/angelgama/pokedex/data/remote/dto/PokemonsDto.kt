package com.angelgama.pokedex.data.remote.dto

data class PokemonsDto(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<PokemonDto>
)
