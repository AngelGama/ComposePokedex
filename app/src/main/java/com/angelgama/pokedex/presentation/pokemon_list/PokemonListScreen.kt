package com.angelgama.pokedex.presentation.pokemon_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.angelgama.pokedex.presentation.Screen
import com.angelgama.pokedex.presentation.pokemon_list.components.PokemonListItem

@Composable
fun PokemonListScreen(
    navController: NavController,
    viewModel: PokemonListViewModel = hiltViewModel(),
    modifier: Modifier
) {
    val state = viewModel.state.value

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(state.pokemons) { pokemon ->
                PokemonListItem(
                    pokemon = pokemon,
                    onItemClick = {
                        navController.navigate(Screen.PokemonDetailScreen.route + "/${pokemon.name}")
                    }
                )
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}