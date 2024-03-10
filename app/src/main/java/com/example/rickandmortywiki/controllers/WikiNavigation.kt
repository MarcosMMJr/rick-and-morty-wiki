package com.example.rickandmortywiki.controllers

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun WikiNavigation(){
    Navigation()
}

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "EpisodesListScreen"){
        composable("CharacterListScreen"){
            // CharacterListScreen()
        }
        composable("EpisodesListScreen"){
            // EpisodesListScreen()
        }
        composable("LocationsListScreen"){
            // LocationsListScreen()
        }
        composable("DetailsScreen"){
            // DetailsScreen()
        }

    }
}