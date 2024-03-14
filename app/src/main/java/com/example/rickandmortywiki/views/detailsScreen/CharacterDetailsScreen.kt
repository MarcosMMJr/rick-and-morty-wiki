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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortywiki.R
import com.example.rickandmortywiki.services.models.CharacterModelResponse
import com.example.rickandmortywiki.services.models.components.CharacterLocationModelResponse
import com.example.rickandmortywiki.services.models.components.CharacterOriginModelResponse
import com.example.rickandmortywiki.ui.theme.DarkBlue20
import com.example.rickandmortywiki.ui.theme.LightBlue40
import com.example.rickandmortywiki.views.components.TopMenuBar
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun CharacterDetailsScreen(
    navController: NavController,
    scrollState: ScrollState,
    characterData: CharacterModelResponse
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
                    characterData.name?.let { characterName ->
                        characterData.status?.let { characterStatus ->
                            CharacterDetailsTitle(
                                name = characterName,
                                status = characterStatus
                            )
                        }
                    }
                }

                Box(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .width(300.dp)
                        .height(300.dp)
                        .align(Alignment.CenterHorizontally)
                ) {
                    characterData.image?.let { CharacterDetailsImage(imageUrl = it) }
                }

                CharacterDetailsBottomHalf(characterData = characterData)
            }
        }
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
fun CharacterDetailsImage(imageUrl: String) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        shadowElevation = 2.dp,
    ) {
        CoilImage(
            imageModel = imageUrl,
            contentDescription = "Profile image",
            error = painterResource(id = R.drawable.image_not_found),
            placeHolder = painterResource(id = R.drawable.portal_placeholder),
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
fun CharacterDetailsBottomHalf(characterData: CharacterModelResponse) {
    Column {

        characterData.status?.let {
            CharacterDescriptionItem(
                title = "Status",
                description = it
            )
        }

        characterData.location?.name?.let {
            CharacterDescriptionItem(
                title = "Last known location",
                description = it
            )
        }


        characterData.species?.let {
            CharacterDescriptionItem(
                title = "Species",
                description = it
            )
        }


        if (characterData.type?.isNotEmpty() == true) {


            CharacterDescriptionItem(
                    title = "Type",
                    description = characterData.type
                )

        }


        characterData.gender?.let {
            CharacterDescriptionItem(
                title = "Gender",
                description = it
            )
        }


        characterData.origin?.name?.let {
            CharacterDescriptionItem(
                title = "Origin",
                description = it
            )
        }

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
        characterData = CharacterModelResponse(
            id = 1,
            name = "Rick Sanchez",
            status = "Alive",
            species = "Human",
            type = "",
            gender = "Male",
            origin = CharacterOriginModelResponse(
                name = "Earth (C-137)",
                url = "https://rickandmortyapi.com/api/location/1"
            ),
            location = CharacterLocationModelResponse(
                name = "Citadel of Ricks",
                url = "https://rickandmortyapi.com/api/location/3",
            ),
            image = "https://rickandmortyapi.com/api/character/avatar/1.jpeg",
            episode = listOf(
                "https://rickandmortyapi.com/api/episode/1",
                "https://rickandmortyapi.com/api/episode/2",
                "https://rickandmortyapi.com/api/episode/3",
            ),
            url = "https://rickandmortyapi.com/api/character/1",
            created = "2017-11-04T18:48:46.250Z"
        ),
    )
}