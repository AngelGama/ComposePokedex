package com.angelgama.pokedex.data.remote.dto

import com.angelgama.pokedex.domain.model.Pokemon

data class PokemonDto(
    val name: String,
    val url: String
)

fun PokemonDto.toPokemon(): Pokemon {

    val id = url.split("/").takeLast(2).first().toInt()

    return Pokemon(
        id = id,
        name = name
    )
}