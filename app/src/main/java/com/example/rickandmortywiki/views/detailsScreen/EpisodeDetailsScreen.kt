package com.example.rickandmortywiki.views.detailsScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortywiki.R
import com.example.rickandmortywiki.services.models.CharacterModel
import com.example.rickandmortywiki.services.models.components.CharacterLocationModel
import com.example.rickandmortywiki.services.models.components.CharacterOriginModel
import com.example.rickandmortywiki.services.models.components.EpisodeUrlModel
import com.example.rickandmortywiki.ui.theme.DarkBlue20
import com.example.rickandmortywiki.ui.theme.LightBlue40

@Composable
fun EpisodeDetailsScreen(
    navController: NavController,
    scrollState: ScrollState,
    characterData: CharacterModel
) {
    Scaffold(topBar = {
        CharacterTopBar {
            navController.popBackStack()
        }
    }) { padding ->
        Surface(color = DarkBlue20) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .verticalScroll(scrollState),
            ) {


                Box(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
                    EpisodeDetailsTitle(name = characterData.name, status = characterData.status)
                }

                EpisodeDetailsBottomHalf(characterData = characterData)
            }
        }
    }
}

@Composable
fun EpisodeDetailsTitle(name: String, status: String) {
    Column {
        Text(
            text = name,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = LightBlue40
        )
        Row {
            Surface(
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(top = 8.dp, start = 2.dp, end = 4.dp)
            ) {
                Surface(
                    content = {},
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .height(5.dp)
                        .width(5.dp),
                    color = colorFilterCheck(status)

                )
            }
            Text(
                text = status,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                color = Color.White
            )

        }
    }
}


@Composable
fun EpisodeDescriptionItem(title: String, description: String) {
    Column(Modifier.padding(start = 16.dp)) {
        Text(
            text = title,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = LightBlue40
        )

        Text(
            text = description,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp,
            color = Color.White
        )

        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun CharactersApparitionItem() {
    Column {
        Box(modifier = Modifier.padding(start = 16.dp)) {

            Text(
                text = "Episodes Apparition",
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = LightBlue40
            )
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 8.dp)
        ) {
            Button(
                modifier = Modifier.align(Alignment.Center),
                shape = MaterialTheme.shapes.small,
                border = BorderStroke(1.dp, LightBlue40),
                colors = ButtonDefaults.buttonColors(DarkBlue20),
                onClick = {}
            ) {
                Text(text = " Episodes List")
            }
        }

        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun EpisodeDetailsBottomHalf(characterData: CharacterModel) {
    Column {

        EpisodeDescriptionItem(
            title = "Status",
            description = characterData.status
        )

        EpisodeDescriptionItem(
            title = "Last known location",
            description = characterData.location.name
        )


        EpisodeDescriptionItem(
            title = "Species",
            description = characterData.species
        )

        EpisodeDescriptionItem(
            title = "Gender",
            description = characterData.gender
        )


        EpisodeDescriptionItem(
            title = "Origin",
            description = characterData.origin.name
        )

        EpisodesApparitionItem()
    }
}


@Preview(showBackground = true)
@Composable
fun EpisodeDetailsScreenPreview() {
    EpisodeDetailsScreen(
        rememberNavController(),
        rememberScrollState(),
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