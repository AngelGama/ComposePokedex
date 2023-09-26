package com.angelgama.pokedex.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.angelgama.pokedex.presentation.pokemon_detail.PokemonDetailScreen
import com.angelgama.pokedex.presentation.pokemon_list.PokemonListScreen
import com.angelgama.pokedex.presentation.ui.theme.PokedexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PokedexTheme(
                dynamicColor = false
            ) {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Text(
                                        text = "Pokedex",
                                        style = MaterialTheme.typography.headlineLarge,
                                    )
                                },
                                colors = TopAppBarDefaults.smallTopAppBarColors(
                                    containerColor = MaterialTheme.colorScheme.primary,
                                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                                )
                            )
                        }
                    ) { padding ->
                        NavHost(
                            navController = navController,
                            startDestination = Screen.PokemonListScreen.route
                        ) {
                            composable(
                                route = Screen.PokemonListScreen.route
                            )
                            {
                                PokemonListScreen(
                                    navController = navController,
                                    modifier = Modifier.padding(padding)
                                )
                            }

                            composable(
                                route = Screen.PokemonDetailScreen.route + "/{pokemonName}"
                            ) {
                                PokemonDetailScreen(modifier = Modifier.padding(padding))
                            }
                        }
                    }
                }
            }
        }
    }
}