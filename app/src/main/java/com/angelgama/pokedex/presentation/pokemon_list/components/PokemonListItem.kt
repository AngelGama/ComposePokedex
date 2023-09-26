package com.angelgama.pokedex.presentation.pokemon_list.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.angelgama.pokedex.R
import com.angelgama.pokedex.common.Constants
import com.angelgama.pokedex.domain.model.Pokemon

@Composable
fun PokemonListItem(
    pokemon: Pokemon,
    onItemClick: (Pokemon) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(pokemon) }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween

    ) {

        Text(
            text = "#${pokemon.id} ${pokemon.name.replaceFirstChar { it.uppercase() }}",
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .padding(start = 10.dp)
        )
        AsyncImage(
            model = "${Constants.BASE_SPRITE_URL}${pokemon.id}.png",
            contentDescription = pokemon.name,
            modifier = Modifier.size(75.dp),
            placeholder = painterResource(id = R.drawable.baseline_image_24),
            error = painterResource(id = R.drawable.baseline_broken_image_24)
        )
    }
    Divider(
        modifier = Modifier.fillMaxWidth()
    )
}