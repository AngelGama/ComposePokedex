package com.angelgama.pokedex.presentation.pokemon_detail

import com.angelgama.pokedex.domain.model.PokemonDetail

data class PokemonDetailState(
    val isLoading: Boolean = false,
    val pokemon: PokemonDetail? = null,
    val error: String = ""
)
