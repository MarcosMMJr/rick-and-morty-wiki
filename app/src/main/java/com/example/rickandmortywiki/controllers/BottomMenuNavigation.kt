package com.example.rickandmortywiki.controllers

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.AutoAwesomeMotion
import androidx.compose.material.icons.outlined.Landscape
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomMenuNavigation(val route: String, val icon: ImageVector, val label: String) {
    object EpisodeListScreen : BottomMenuNavigation(
            "EpisodeListScreen",
            icon = Icons.Outlined.AutoAwesomeMotion,
            label = "Episodes"
        )

    object CharacterListScreen : BottomMenuNavigation(
        "CharacterListScreen",
        icon = Icons.Outlined.AccountCircle,
        label = "Characters"
    )

    object LocationListScreen : BottomMenuNavigation(
            "LocationListScreen",
            icon = Icons.Outlined.Landscape,
            label = "Locations"
        )
}