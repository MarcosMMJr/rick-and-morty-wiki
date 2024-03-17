package com.example.rickandmortywiki.controllers

import android.util.Log
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.rickandmortywiki.services.managers.EpisodesManager
import com.example.rickandmortywiki.services.managers.LocationsManager
import com.example.rickandmortywiki.services.models.CharacterModelResponse
import com.example.rickandmortywiki.services.models.EpisodeModelResponse
import com.example.rickandmortywiki.services.models.LocationModelResponse
import com.example.rickandmortywiki.views.cardListScreen.CharacterListScreen
import com.example.rickandmortywiki.views.cardListScreen.EpisodeListScreen
import com.example.rickandmortywiki.views.cardListScreen.LocationListScreen
import com.example.rickandmortywiki.views.components.BottomMenu
import com.example.rickandmortywiki.views.detailsScreen.CharacterDetailsScreen
import com.example.rickandmortywiki.views.detailsScreen.EpisodeDetailsScreen
import com.example.rickandmortywiki.views.detailsScreen.LocationDetailsScreen

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
    episodesManager: EpisodesManager = EpisodesManager(),
    locationsManager: LocationsManager = LocationsManager()
) {

    val charactersData = charactersManager.charactersResponse.value.results
    val episodesData = episodesManager.episodesResponse.value.results
    val locationsData = locationsManager.locationsResponse.value.results

    Log.d("pages of Characters", "$charactersData \n\n")
    Log.d("pages of Episodes", "$episodesData \n\n")
    Log.d("pages of Locations", "$locationsData \n\n")

    charactersData?.let {characters ->
        episodesData?.let {
            locationsData?.let {
                NavHost(
                    navController = navHostController,
                    startDestination =
                    BottomMenuNavigation.CharacterListScreen.route,
                ) {
                    bottomNavigation(
                        navController = navHostController,
                        characters = charactersData,
                        episodes = episodesData,
                        locations = locationsData
                    )

                    composable(
                        "CharacterDetailsScreen/{characterId}",
                        arguments = listOf(navArgument("characterId") { type = NavType.IntType })
                    ) { navBackStackEntry ->
                        val characterId = navBackStackEntry.arguments?.getInt("characterId")
                        characterId?.let {
                            val characterData = charactersData.find { it.id == characterId }
                            characterData?.let {
                                CharacterDetailsScreen(
                                    navController = navHostController,
                                    scrollState = scrollState,
                                    characterData = it
                                )
                            }
                        }
                    }




                    composable(
                        "EpisodeDetailsScreen/{index}",
                        arguments = listOf(navArgument("index") { type = NavType.IntType })
                    ) { navBackStackEntry ->
                        val episodeIndex = navBackStackEntry.arguments?.getInt("index")
                        episodeIndex?.let {
                            val episodeData = episodesData[episodeIndex]
                            EpisodeDetailsScreen(
                                navController = navHostController,
                                scrollState = scrollState,
                                episodeData = episodeData
                            )
                        }
                    }

                    composable(
                        "LocationDetailsScreen/{index}",
                        arguments = listOf(navArgument("index") { type = NavType.IntType })
                    ) { navBackStackEntry ->
                        val locationIndex = navBackStackEntry.arguments?.getInt("index")
                        locationIndex?.let {
                            val locationData = locationsData[locationIndex]
                            LocationDetailsScreen(
                                navController = navHostController,
                                scrollState = scrollState,
                                locationData = locationData
                            )
                        }
                    }
                }
            }
        }
    }
}

fun NavGraphBuilder.bottomNavigation(
    navController: NavController,
    characters: List<CharacterModelResponse>,
    episodes: List<EpisodeModelResponse>,
    locations: List<LocationModelResponse>
) {
    composable(BottomMenuNavigation.EpisodeListScreen.route) {
        EpisodeListScreen(navController = navController, episodes = episodes)

    }
    composable(BottomMenuNavigation.CharacterListScreen.route) {
        CharacterListScreen(navController = navController, charactersManager = CharactersManager())
    }


    composable(BottomMenuNavigation.LocationListScreen.route) {
        LocationListScreen(navController = navController, locations = locations)
    }


}