package com.angelgama.pokedex.presentation.pokemon_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.angelgama.pokedex.common.Resource
import com.angelgama.pokedex.domain.use_case.get_pokemons.GetPokemonsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val getPokemonsUseCase: GetPokemonsUseCase
) : ViewModel() {

    private val _state = mutableStateOf(PokemonListSate())
    val state: State<PokemonListSate> = _state

    init {
        getPokemons()
    }

    private fun getPokemons() {
        getPokemonsUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = PokemonListSate(pokemons = result.data ?: emptyList())
                }

                is Resource.Error -> {
                    _state.value =
                        PokemonListSate(error = result.message ?: "An unexpected error occurred")
                }

                is Resource.Loading -> {
                    _state.value = PokemonListSate(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}