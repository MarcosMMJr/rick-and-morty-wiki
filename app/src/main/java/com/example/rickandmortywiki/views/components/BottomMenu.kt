package com.example.rickandmortywiki.views.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Surface
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortywiki.controllers.BottomMenuNavigation
import com.example.rickandmortywiki.ui.theme.DarkBlue20
import com.example.rickandmortywiki.ui.theme.DarkBlue40
import com.example.rickandmortywiki.ui.theme.LightBlue40

@Composable
fun BottomMenu(navController: NavController) {
    val menuItems = listOf(
        BottomMenuNavigation.EpisodeListScreen,
        BottomMenuNavigation.CharacterListScreen,
        BottomMenuNavigation.LocationListScreen
    )
    Surface(elevation = 16.dp) {

        BottomNavigation(
            backgroundColor = DarkBlue20,
            elevation = 4.dp
        ) {

            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route

            menuItems.forEach {
                BottomNavigationItem(
                    label = {
                        Text(
                            text = it.label,
                            color = selectedTabColor(currentRoute, it.route)
                        )
                    },
                    icon = {
                        Icon(
                            it.icon,
                            contentDescription = it.label,
                            tint = selectedTabColor(currentRoute, it.route)
                        )
                    },
                    alwaysShowLabel = true,
                    selectedContentColor = DarkBlue40,
                    unselectedContentColor = Color.White,
                    selected = currentRoute == it.route,
                    onClick = {
                        bottomNavigationClickAction(navController, it)
                    },
                )
            }
        }
    }
}

fun selectedTabColor(currentRoute: String?, route: String): Color {
    return if (currentRoute == route) {
        LightBlue40
    } else {
        Color.White
    }
}

fun bottomNavigationClickAction(navController: NavController, it: BottomMenuNavigation) {
    navController.navigate(it.route) {
        navController.graph.startDestinationRoute?.let { route ->
            popUpTo(route) {
                saveState = true
            }

        }
        launchSingleTop = true
        restoreState = true
    }
}

@Preview
@Composable
fun BottomMenuPreview() {
    BottomMenu(navController = rememberNavController())
}