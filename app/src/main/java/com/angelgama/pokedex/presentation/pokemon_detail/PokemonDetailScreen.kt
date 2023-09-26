package com.angelgama.pokedex.presentation.pokemon_detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.angelgama.pokedex.R

@Composable
fun PokemonDetailScreen(
    viewModel: PokemonDetailViewModel = hiltViewModel(),
    modifier: Modifier
) {

    val state = viewModel.state.value

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        state.pokemon?.let { pokemon ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Text(
                        text = pokemon.name.replaceFirstChar { it.uppercase() },
                        style = MaterialTheme.typography.headlineLarge,
                        color = MaterialTheme.colorScheme.primary,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    AsyncImage(
                        model = pokemon.spriteUrl,
                        contentDescription = pokemon.name,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        placeholder = painterResource(id = R.drawable.baseline_image_24),
                        contentScale = ContentScale.Crop,
                        error = painterResource(id = R.drawable.baseline_broken_image_24)
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Weight: ${pokemon.weight} hg",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Text(
                            text = "Height: ${pokemon.height} dm",
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
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


