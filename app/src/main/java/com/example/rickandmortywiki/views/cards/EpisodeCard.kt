package com.example.rickandmortywiki.views.cards

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
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
import com.example.rickandmortywiki.services.models.EpisodeModelResponse
import com.example.rickandmortywiki.ui.theme.DarkBlue40
import com.example.rickandmortywiki.ui.theme.LightBlue40

@Composable
fun EpisodeCard(episodeData: EpisodeModelResponse, onEpisodeCardClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .height(100.dp)
            .width(400.dp)
            .padding(8.dp)
            .clickable {
                onEpisodeCardClick()
            },

        ) {
        EpisodeCardStructure(episodeData)
    }
}


@Composable
fun EpisodeCardStructure(episodeData: EpisodeModelResponse) {

    Surface(
        color = DarkBlue40,
        modifier = Modifier.fillMaxSize(),
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 8.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {


            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                episodeData.id?.let { id ->
                    episodeData.name?.let { title ->
                        EpisodeTitleStructure(
                            id,
                            title
                        )
                    }
                }


                Spacer(modifier = Modifier.height(10.dp))

                episodeData.airDate?.let { EpisodeSubtitleStructure("Air Date: ", it) }
                episodeData.episode?.let { EpisodeStructure(it) }
            }
        }
    }
}

@Composable
fun EpisodeTitleStructure(id: Int, title: String) {
    Row {
        Text(
            text = "${id}. ",
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

@Composable
fun EpisodeSubtitleStructure(title: String, item: String) {

    Row {
        Text(
            text = title,
            color = LightBlue40,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
        Text(
            text = item,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    }
}

@Composable
fun EpisodeStructure(episodeNumber: String) {

    val season = episodeNumber.substring(1, 3)
    val episode = episodeNumber.substring(4, 6)

    Row {
        Text(
            text = "Season: ",
            color = LightBlue40,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
        Text(
            text = season,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )

        Spacer(modifier = Modifier.width(20.dp))

        Text(
            text = "Episode: ",
            color = LightBlue40,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
        Text(
            text = episode,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun EpisodeCardPreview() {
    EpisodeCard(
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