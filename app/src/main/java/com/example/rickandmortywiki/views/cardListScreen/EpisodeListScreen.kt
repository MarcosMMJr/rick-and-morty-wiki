package com.example.rickandmortywiki.views.cardListScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortywiki.services.mockData.MockCharacterData
import com.example.rickandmortywiki.services.mockData.MockEpisodeData
import com.example.rickandmortywiki.services.models.EpisodeModelResponse
import com.example.rickandmortywiki.ui.theme.DarkBlue20
import com.example.rickandmortywiki.ui.theme.LightBlue40
import com.example.rickandmortywiki.views.cards.CharacterCard
import com.example.rickandmortywiki.views.cards.EpisodeCard

@Composable
fun EpisodeListScreen(navController: NavController, episodes: List<EpisodeModelResponse>) {
    Surface(color = DarkBlue20) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = "Episodes",
                fontWeight = FontWeight.Bold,
                color = LightBlue40,
            )

            LazyColumn {
                items(episodes.size) { index ->
                    EpisodeCard(
                        episodeData = episodes[index],
                        onEpisodeCardClick = { navController.navigate("EpisodeDetailsScreen/$index") }
                    )
                }
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun EpisodeListScreenPreview() {
    EpisodeListScreen(rememberNavController(), MockEpisodeData.episodesList)
}