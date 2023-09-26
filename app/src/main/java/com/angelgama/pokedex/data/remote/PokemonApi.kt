package com.angelgama.pokedex.data.remote

import com.angelgama.pokedex.data.remote.dto.PokemonDetailDto
import com.angelgama.pokedex.data.remote.dto.PokemonsDto
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("api/v2/pokemon")
    suspend fun getPokemons(): PokemonsDto

    @GET("api/v2/pokemon/{pokemonName}")
    suspend fun getPokemonByName(@Path("pokemonName") pokemonName: String): PokemonDetailDto

}