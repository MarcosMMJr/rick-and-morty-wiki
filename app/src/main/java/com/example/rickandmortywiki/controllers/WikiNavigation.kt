package com.example.rickandmortywiki.controllers

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.rickandmortywiki.services.models.mockData.MockCharacterData
import com.example.rickandmortywiki.views.DetailsScreen
import com.example.rickandmortywiki.views.GeneralCardListScreen

@Composable
fun WikiNavigation() {
    Navigation()
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "GeneralCardListScreen") {
        composable("GeneralCardListScreen") {
            GeneralCardListScreen(navController = navController)
        }
        composable("EpisodesListScreen") {
            // EpisodesListScreen()
        }
        composable("LocationsListScreen") {
            // LocationsListScreen()
        }
        composable("DetailsScreen/{characterId}",
            arguments = listOf(navArgument("characterId") { type = NavType.IntType })
        ) { navBackStackEntry ->
            val characterId = navBackStackEntry.arguments?.getInt("characterId")
            val characterData = MockCharacterData.getCharacterById(characterId)
            DetailsScreen(navController = navController, characterData = characterData)
        }

    }
}