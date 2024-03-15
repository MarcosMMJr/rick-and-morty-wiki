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
import com.example.rickandmortywiki.services.models.LocationModelResponse
import com.example.rickandmortywiki.services.models.components.CharacterLocationModel
import com.example.rickandmortywiki.services.models.components.CharacterOriginModel
import com.example.rickandmortywiki.services.models.components.EpisodeUrlModel
import com.example.rickandmortywiki.ui.theme.DarkBlue20
import com.example.rickandmortywiki.ui.theme.LightBlue40
import com.example.rickandmortywiki.views.cards.LocationCard
import com.example.rickandmortywiki.views.components.TopMenuBar

@Composable
fun LocationDetailsScreen(
    navController: NavController,
    scrollState: ScrollState,
    locationData: LocationModelResponse
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
                    locationData.name?.let { title ->
                        LocationDetailsTitle(title = title)
                    }

                }

                LocationDetailsBottomHalf(locationData = locationData)
            }
        }
    }
}

@Composable
fun LocationDetailsTitle(title: String) {
    Row {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = LightBlue40
        )

    }
}


@Composable
fun LocationDescriptionItem(title: String, description: String) {
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
fun LocationDetailsBottomHalf(locationData: LocationModelResponse) {
    Column {
        Spacer(modifier = Modifier.height(15.dp))

        locationData.type?.let { LocationDescriptionItem("Type", it) }
        locationData.dimension?.let { LocationDescriptionItem("Dimension", it) }

        CharactersApparitionItem("Characters who appeared in this location")
    }
}


@Preview(showBackground = true)
@Composable
fun LocationDetailsScreenPreview() {
    LocationDetailsScreen(
        rememberNavController(),
        rememberScrollState(),
        locationData =
        LocationModelResponse(
            id = 2,
            name = "Abadango",
            type = "Cluster",
            dimension = "unknown",
            residents = listOf(
                "https://rickandmortyapi.com/api/character/6"
            ),
            url = "https://rickandmortyapi.com/api/location/2",
            created = "2017-11-10T13:06:38.182Z"
        ),
    )

}