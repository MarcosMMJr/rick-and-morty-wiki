package com.example.rickandmortywiki.views

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rickandmortywiki.controllers.WikiNavigation
import com.example.rickandmortywiki.ui.theme.RickAndMortyWikiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyWikiTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    WikiNavigation()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun HomeNavigationPreview() {
    RickAndMortyWikiTheme {
        WikiNavigation()
    }
}