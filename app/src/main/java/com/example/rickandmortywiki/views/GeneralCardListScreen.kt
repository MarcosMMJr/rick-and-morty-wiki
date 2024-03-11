package com.example.rickandmortywiki.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortywiki.services.models.mockData.MockCharacterData
import com.example.rickandmortywiki.ui.theme.DarkBlue20
import com.example.rickandmortywiki.views.components.CharacterCard

@Composable
fun GeneralCardListScreen(navController: NavController) {
    Surface(color = DarkBlue20) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,

            ) {
            Text(
                text = "Tela de Listas",
                fontWeight = FontWeight.Bold,
                color = Color.White,
            )

            LazyColumn {
                items(MockCharacterData.charactersList) { characterData ->
                    CharacterCard(characterData = characterData, onCharacterCardClick = {
                        navController.navigate("DetailsScreen/${characterData.id}")
                    })
                }
            }

            Button(onClick = {
                navController.navigate("DetailsScreen")
            }) {
                Text(text = "Detalhes")
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GeneralCardListScreenPreview() {
    GeneralCardListScreen(rememberNavController())
}