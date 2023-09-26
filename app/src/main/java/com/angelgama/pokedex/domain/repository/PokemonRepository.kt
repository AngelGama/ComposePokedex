package com.angelgama.pokedex.domain.repository

import com.angelgama.pokedex.data.remote.dto.PokemonDetailDto
import com.angelgama.pokedex.data.remote.dto.PokemonsDto

interface PokemonRepository {

    suspend fun getPokemons(): PokemonsDto

    suspend fun getPokemonByName(pokemonName: String): PokemonDetailDto
}