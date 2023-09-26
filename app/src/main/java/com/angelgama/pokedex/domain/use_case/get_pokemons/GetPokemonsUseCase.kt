package com.angelgama.pokedex.domain.use_case.get_pokemons

import com.angelgama.pokedex.common.Resource
import com.angelgama.pokedex.data.remote.dto.toPokemon
import com.angelgama.pokedex.domain.model.Pokemon
import com.angelgama.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonsUseCase @Inject constructor(
    private val repository: PokemonRepository
) {
    operator fun invoke(): Flow<Resource<List<Pokemon>>> = flow {
        try {
            emit(Resource.Loading())
            val pokemons = repository.getPokemons().results.map { it.toPokemon() }
            emit(Resource.Success(pokemons))
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection"))
        }
    }
}