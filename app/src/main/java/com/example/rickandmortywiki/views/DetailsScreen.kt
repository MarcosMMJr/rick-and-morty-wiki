package com.example.rickandmortywiki.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortywiki.R
import com.example.rickandmortywiki.services.models.CharacterModel
import com.example.rickandmortywiki.services.models.components.CharacterLocationModel
import com.example.rickandmortywiki.services.models.components.CharacterOriginModel
import com.example.rickandmortywiki.services.models.components.EpisodeUrlModel

@Composable
fun DetailsScreen(navController: NavController, characterData: CharacterModel) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Tela de Detalhes",
            fontWeight = FontWeight.SemiBold
        )
        Text(
            text = "characterData: ${characterData.name}",
            fontWeight = FontWeight.SemiBold
        )
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text = "Voltar para tela de Listas")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(
        rememberNavController(),
        characterData = CharacterModel(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = CharacterOriginModel(
                name = "Earth (C-137)",
                url = "https://rickandmortyapi.com/api/location/1"
            ),
            location = CharacterLocationModel(
                name = "Citadel of Ricks",
                url = "https://rickandmortyapi.com/api/location/3",
            ),
            image = R.drawable.rick_sanchez,
            episode = listOf(
                EpisodeUrlModel("https://rickandmortyapi.com/api/episode/1"),
                EpisodeUrlModel("https://rickandmortyapi.com/api/episode/2"),
                EpisodeUrlModel("https://rickandmortyapi.com/api/episode/3"),
            ),
            url = "https://rickandmortyapi.com/api/character/1",
            created = "2017-11-04T18:48:46.250Z"
        ),
    )
}