package com.example.rickandmortywiki.views.cards

import androidx.compose.foundation.Image
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
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortywiki.R
import com.example.rickandmortywiki.services.models.CharacterModel
import com.example.rickandmortywiki.services.models.components.CharacterLocationModel
import com.example.rickandmortywiki.services.models.components.CharacterOriginModel
import com.example.rickandmortywiki.services.models.components.EpisodeUrlModel
import com.example.rickandmortywiki.ui.theme.DarkBlue40
import com.example.rickandmortywiki.ui.theme.LightBlue40

@Composable
fun CharacterCard(characterData: CharacterModel, onCharacterCardClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .height(150.dp)
            .width(400.dp)
            .padding(8.dp)
            .clickable {
                onCharacterCardClick()
            },
    ) {
        CharacterCardStructure(characterData)
    }
}


@Composable
fun CharacterCardStructure(characterData: CharacterModel) {
    Surface(
        color = DarkBlue40,
        modifier = Modifier.fillMaxSize(),
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 4.dp
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {

            CharacterImage(characterData.image)

            Column(
                modifier = Modifier
                    .wrapContentHeight()
                    .padding(start = 16.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = characterData.name,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(15.dp))
                CharacterSubtitleStructure("Status: ", characterData.status)
                CharacterSubtitleStructure("Species: ", characterData.species)
                CharacterSubtitleStructure("Origin: ", characterData.origin.name)
            }
        }
    }
}

@Composable
fun CharacterImage(imageId: Int) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier.padding(start = 16.dp),
        shadowElevation = 2.dp
    ) {
        Image(
            painter = painterResource(imageId),
            contentDescription = "Profile image",
            contentScale = ContentScale.FillBounds
        )
    }
}

@Composable
fun CharacterSubtitleStructure(title: String, item: String) {

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


@Preview(showBackground = true)
@Composable
fun CharacterCardPreview() {
    CharacterCard(
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