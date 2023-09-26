package com.angelgama.pokedex.di

import com.angelgama.pokedex.common.Constants
import com.angelgama.pokedex.data.remote.PokemonApi
import com.angelgama.pokedex.data.repository.PokemonRepositoryImpl
import com.angelgama.pokedex.domain.repository.PokemonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providePokemonApi(): PokemonApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PokemonApi::class.java)
    }

    @Provides
    @Singleton
    fun providePokemonRepository(api: PokemonApi): PokemonRepository {
        return PokemonRepositoryImpl(api)
    }

}