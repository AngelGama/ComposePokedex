package com.angelgama.pokedex.presentation.pokemon_list

import com.angelgama.pokedex.domain.model.Pokemon

data class PokemonListSate(
    val isLoading: Boolean = false,
    val pokemons: List<Pokemon> = emptyList(),
    val error: String = ""
)
