package com.example.rickandmortywiki.controllers

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortywiki.services.managers.CharactersManager
import com.example.rickandmortywiki.services.mockData.MockCharacterData
import com.example.rickandmortywiki.services.models.CharacterModelResponse
import com.example.rickandmortywiki.views.cardListScreen.CharacterListScreen
import com.example.rickandmortywiki.views.cardListScreen.EpisodeListScreen
import com.example.rickandmortywiki.views.cardListScreen.LocationListScreen
import com.example.rickandmortywiki.views.components.BottomMenu
import com.example.rickandmortywiki.views.detailsScreen.CharacterDetailsScreen

@Composable
fun WikiNavigation() {
    val navController = rememberNavController()
    val scrollState = rememberScrollState()

    BottomMenuBar(navController = navController, scrollState = scrollState)
}

@Composable
fun BottomMenuBar(navController: NavHostController, scrollState: ScrollState) {
    Scaffold(bottomBar = {
        BottomMenu(navController = navController)
    }) { padding ->
        Box(modifier = Modifier.padding(padding)) {
            Navigation(
                navHostController = navController,
                scrollState = scrollState,
            )
        }
    }
}

@Composable
fun Navigation(
    navHostController: NavHostController,
    scrollState: ScrollState,
    charactersManager: CharactersManager = CharactersManager(),
) {

    val charactersData = charactersManager.charactersResponse.value.results
    Log.d("pages of Characters", "$charactersData \n\n")

    charactersData?.let {

        NavHost(
            navController = navHostController,
            startDestination =
            BottomMenuNavigation.CharacterListScreen.route,
        ) {
            bottomNavigation(navController = navHostController, characters = charactersData)

            composable("EpisodesListScreen") {
//             EpisodeListScreen(navHostController = navHostController)
            }
            composable("LocationsListScreen") {
//             LocationListScreen(navHostController = navHostController)
            }
            composable(
                "CharacterDetailsScreen/{index}",
                arguments = listOf(navArgument("index") { type = NavType.IntType })
            ) { navBackStackEntry ->
                val characterIndex = navBackStackEntry.arguments?.getInt("index")
                characterIndex?.let{
                    val characterData = charactersData[characterIndex]
                    CharacterDetailsScreen(
                        navController = navHostController,
                        scrollState = scrollState,
                        characterData = characterData
                    )
                }
            }
        }
    }
}

fun NavGraphBuilder.bottomNavigation(
    navController: NavController,
    characters: List<CharacterModelResponse>
) {
    composable(BottomMenuNavigation.EpisodeListScreen.route) {
        EpisodeListScreen(navController = navController)

    }
    composable(BottomMenuNavigation.CharacterListScreen.route) {
        CharacterListScreen(navController = navController, characters = characters)

    }
    composable(BottomMenuNavigation.LocationListScreen.route) {
        LocationListScreen(navController = navController)
    }


}