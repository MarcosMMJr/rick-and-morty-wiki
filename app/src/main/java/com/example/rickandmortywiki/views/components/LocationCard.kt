package com.example.rickandmortywiki.views.components

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
import com.example.rickandmortywiki.services.models.EpisodeModel
import com.example.rickandmortywiki.services.models.LocationModel
import com.example.rickandmortywiki.services.models.components.CharacterLocationModel
import com.example.rickandmortywiki.services.models.components.CharacterOriginModel
import com.example.rickandmortywiki.services.models.components.CharacterUrlModel
import com.example.rickandmortywiki.services.models.components.EpisodeUrlModel
import com.example.rickandmortywiki.ui.theme.DarkBlue40
import com.example.rickandmortywiki.ui.theme.LightBlue40

@Composable
fun LocationCard(locationData: LocationModel, onLocationCardClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .height(100.dp)
            .width(400.dp)
            .padding(8.dp)
            .clickable {
                onLocationCardClick()
            },

        ) {
        LocationCardStructure(locationData)
    }
}


@Composable
fun LocationCardStructure(locationData: LocationModel) {

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

                Text(
                    text = locationData.name,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )


                Spacer(modifier = Modifier.height(10.dp))

                LocationSubtitleStructure("Type: ", locationData.type)
                LocationSubtitleStructure("Dimension: ", locationData.dimension)

            }
        }
    }
}


@Composable
fun LocationSubtitleStructure(title: String, item: String) {

    var dimensionRemover = item.replace("Dimension ", "")

    Row {
        Text(
            text = title,
            color = LightBlue40,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
        Text(
            text = dimensionRemover,
            color = Color.White,
            fontWeight = FontWeight.Normal,
            fontSize = 12.sp
        )
    }
}


@Preview(showBackground = true)
@Composable
fun LocationCardPreview() {
    LocationCard(
        LocationModel(
            id = 2,
            name = "Abadango",
            type = "Cluster",
            dimension = "unknown",
            residents = listOf(
                CharacterUrlModel("https://rickandmortyapi.com/api/character/6")
            ),
            url = "https://rickandmortyapi.com/api/location/2",
            created = "2017-11-10T13:06:38.182Z"
        ),
    )
}