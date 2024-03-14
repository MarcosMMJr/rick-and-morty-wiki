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
import com.example.rickandmortywiki.services.models.EpisodeModelResponse
import com.example.rickandmortywiki.services.models.components.CharacterLocationModel
import com.example.rickandmortywiki.services.models.components.CharacterOriginModel
import com.example.rickandmortywiki.services.models.components.EpisodeUrlModel
import com.example.rickandmortywiki.ui.theme.DarkBlue20
import com.example.rickandmortywiki.ui.theme.LightBlue40
import com.example.rickandmortywiki.views.components.TopMenuBar

@Composable
fun EpisodeDetailsScreen(
    navController: NavController,
    scrollState: ScrollState,
    episodeData: EpisodeModelResponse
) {
    Scaffold(topBar = {
        TopMenuBar {
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
                    episodeData.id?.let { id ->
                        episodeData.name?.let { title ->
                            EpisodeDetailsTitle(
                                id = id,
                                title = title
                            )
                        }
                    }
                }

                EpisodeDetailsBottomHalf(episodeData = episodeData)
            }
        }
    }
}

@Composable
fun EpisodeDetailsTitle(id: Int, title: String) {
    Row {
        Text(
            text = "$id. ",
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = Color.White
        )

        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = LightBlue40
        )

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
                text = "Characters in this episode",
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
                Text(text = "Characters List")
            }
        }

        Spacer(modifier = Modifier.height(15.dp))
    }
}

@Composable
fun EpisodeStructureItem(episodeNumber: String) {

    val season = episodeNumber.substring(1, 3)
    val episode = episodeNumber.substring(4, 6)

    Column (modifier = Modifier.padding(start = 16.dp)) {
        Text(
            text = "Season",
            color = LightBlue40,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
        Text(
            text = season,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

        Text(
            text = "Episode",
            color = LightBlue40,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        )
        Text(
            text = episode,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.height(15.dp))

    }
}

@Composable
fun EpisodeDetailsBottomHalf(episodeData: EpisodeModelResponse) {
    Column {

        episodeData.airDate?.let {
            EpisodeDescriptionItem(
                title = "Air Date",
                description = it
            )
        }

        episodeData.episode?.let {
            EpisodeStructureItem(
                episodeNumber = it
            )
        }

        CharactersApparitionItem()
    }
}


@Preview(showBackground = true)
@Composable
fun EpisodeDetailsScreenPreview() {
    EpisodeDetailsScreen(
        rememberNavController(),
        rememberScrollState(),
        episodeData = EpisodeModelResponse(
            id = 1,
            name = "Pilot",
            airDate = "December 2, 2013",
            episode = "S01E01",
            characters = listOf(
                "https://rickandmortyapi.com/api/character/1",
                "https://rickandmortyapi.com/api/character/2",
                "https://rickandmortyapi.com/api/character/35",
                "https://rickandmortyapi.com/api/character/38",
                "https://rickandmortyapi.com/api/character/62",
                "https://rickandmortyapi.com/api/character/92",
                "https://rickandmortyapi.com/api/character/127",
                "https://rickandmortyapi.com/api/character/144",
                "https://rickandmortyapi.com/api/character/158",
                "https://rickandmortyapi.com/api/character/175",
                "https://rickandmortyapi.com/api/character/179",
                "https://rickandmortyapi.com/api/character/181",
                "https://rickandmortyapi.com/api/character/239",
                "https://rickandmortyapi.com/api/character/249",
                "https://rickandmortyapi.com/api/character/271",
                "https://rickandmortyapi.com/api/character/338",
                "https://rickandmortyapi.com/api/character/394",
                "https://rickandmortyapi.com/api/character/395",
                "https://rickandmortyapi.com/api/character/435"
            ),
            url = "https://rickandmortyapi.com/api/episode/1",
            created = "2017-11-10T12:56:33.798Z"
        )
    )
}