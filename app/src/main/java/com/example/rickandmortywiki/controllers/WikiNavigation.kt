package com.example.rickandmortywiki.controllers

import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortywiki.services.models.mockData.MockCharacterData
import com.example.rickandmortywiki.views.detailsScreen.CharacterDetailsScreen
import com.example.rickandmortywiki.views.cardListScreen.CharacterCardListScreen

@Composable
fun WikiNavigation() {
    Navigation()
}

@Composable
fun Navigation() {
    val navController = rememberNavController()
    val scrollState = rememberScrollState()

    NavHost(navController = navController, startDestination = "CharacterCardListScreen") {
        composable("CharacterCardListScreen") {
            CharacterCardListScreen(navController = navController)
        }
        composable("EpisodesListScreen") {
            // EpisodesListScreen()
        }
        composable("LocationsListScreen") {
            // LocationsListScreen()
        }
        composable("CharacterDetailsScreen/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val characterId = navBackStackEntry.arguments?.getInt("characterId")
            val characterData = MockCharacterData.getCharacterById(characterId)
            CharacterDetailsScreen(navController = navController, scrollState = scrollState, characterData = characterData)
        }

    }
}