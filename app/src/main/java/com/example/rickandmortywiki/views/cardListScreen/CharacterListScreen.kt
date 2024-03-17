package com.example.rickandmortywiki.views.cardListScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortywiki.services.managers.CharactersManager
import com.example.rickandmortywiki.ui.theme.DarkBlue20
import com.example.rickandmortywiki.ui.theme.LightBlue40
import com.example.rickandmortywiki.views.cards.CharacterCard

@Composable
fun CharacterListScreen(navController: NavController, charactersManager: CharactersManager) {
    val characters by charactersManager.charactersResponse
    val listState = rememberLazyListState()

    Surface(color = DarkBlue20) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Characters", fontWeight = FontWeight.Bold, color = LightBlue40)

            var selectedCharacterId by remember { mutableStateOf<Int?>(null) }

            LazyColumn(state = listState) {
                characters.results?.let { characters ->
                    items(characters.size) { index ->
                        CharacterCard(
                            characterData = characters[index],
                            onCharacterCardClick = {
                                selectedCharacterId = characters[index].id
                                navController.navigate("CharacterDetailsScreen/${selectedCharacterId}")
                            }
                        )
                    }
                }



                item {
                    Button(
                        onClick = { charactersManager.fetchNextPage() },
                        modifier = Modifier.fillMaxWidth().padding(16.dp)
                    ) {
                        Text("Carregar Mais")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CharacterListScreenPreview() {
    CharacterListScreen(rememberNavController(), CharactersManager())
}