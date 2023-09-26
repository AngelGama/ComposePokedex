package com.angelgama.pokedex.domain.model

data class PokemonDetail(
    val pokemonId: Int,
    val name: String,
    val spriteUrl: String,
    val weight: Int,
    val height: Int
)
