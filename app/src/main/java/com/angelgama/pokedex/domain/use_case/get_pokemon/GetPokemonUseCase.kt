package com.angelgama.pokedex.domain.use_case.get_pokemon

import com.angelgama.pokedex.common.Resource
import com.angelgama.pokedex.data.remote.dto.toPokemonDetail
import com.angelgama.pokedex.domain.model.PokemonDetail
import com.angelgama.pokedex.domain.repository.PokemonRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPokemonUseCase @Inject constructor(
    private val repository: PokemonRepository
) {

    operator fun invoke(pokemonName: String): Flow<Resource<PokemonDetail>> = flow {
        try {
            emit(Resource.Loading())
            val pokemon = repository.getPokemonByName(pokemonName).toPokemonDetail()
            emit(Resource.Success(pokemon))
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