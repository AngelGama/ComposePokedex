package com.angelgama.pokedex.data.repository

import com.angelgama.pokedex.data.remote.PokemonApi
import com.angelgama.pokedex.data.remote.dto.PokemonDetailDto
import com.angelgama.pokedex.data.remote.dto.PokemonsDto
import com.angelgama.pokedex.domain.repository.PokemonRepository
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val api: PokemonApi
) : PokemonRepository {

    override suspend fun getPokemons(): PokemonsDto {
        return api.getPokemons()
    }

    override suspend fun getPokemonByName(pokemonName: String): PokemonDetailDto {
        return api.getPokemonByName(pokemonName)
    }

}