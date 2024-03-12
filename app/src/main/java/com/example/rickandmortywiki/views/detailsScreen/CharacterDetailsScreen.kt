package com.example.rickandmortywiki.views.detailsScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
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
fun CharacterDetailsScreen(
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
                    .padding(padding),
            ) {


                Box(modifier = Modifier.padding(top = 16.dp, start = 16.dp)) {
                    CharacterDetailsTitle(name = characterData.name, status = characterData.status)
                }

                Box(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .width(340.dp)
                        .height(340.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    CharacterDetailsImage(imageId = characterData.image)
                }

                CharacterDetailsBottomHalf(characterData = characterData, scrollState)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterTopBar(onBackPressed: () -> Unit = {}) {

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 4.dp,
    ) {
        TopAppBar(title = {
            Text(
                text = "Character Details",
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = LightBlue40,
            )
        }, navigationIcon = {
            IconButton(onClick = { onBackPressed() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back button",
                    tint = LightBlue40
                )
            }

        }, colors = TopAppBarDefaults.topAppBarColors(DarkBlue20))
    }

}

@Composable
fun CharacterDetailsTitle(name: String, status: String) {
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
fun CharacterDetailsImage(imageId: Int) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 2.dp,
    ) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = "Profile Image",
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun CharacterDescriptionItem(title: String, description: String) {
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
fun EpisodesApparitionItem() {
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
fun CharacterDetailsBottomHalf(characterData: CharacterModel, scrollState: ScrollState) {
    Column(modifier = Modifier.verticalScroll(scrollState)) {

        CharacterDescriptionItem(
            title = "Status",
            description = characterData.status
        )

        CharacterDescriptionItem(
            title = "Last known location",
            description = characterData.location.name
        )


        CharacterDescriptionItem(
            title = "Species",
            description = characterData.species
        )


        if (characterData.type.isNotEmpty()) {


            CharacterDescriptionItem(
                title = "Type",
                description = characterData.type
            )

        }


        CharacterDescriptionItem(
            title = "Gender",
            description = characterData.gender
        )


        CharacterDescriptionItem(
            title = "Origin",
            description = characterData.origin.name
        )

        EpisodesApparitionItem()
    }
}


fun colorFilterCheck(status: String): Color {
    return when (status) {
        "Alive" -> Color.Green
        "Dead" -> Color.Red
        else -> Color.Yellow
    }
}


@Preview(showBackground = true)
@Composable
fun CharacterDetailsScreenPreview() {
    CharacterDetailsScreen(
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