package com.example.rickandmortywiki.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun DetailsScreen(navController: NavController) {
    Column (
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text = "Tela de Detalhes",
            fontWeight = FontWeight.SemiBold
        )
        Button(onClick = {
            navController.popBackStack()
        }) {
            Text(text ="Voltar para tela de Listas")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DetailsScreenPreview() {
    DetailsScreen(rememberNavController())
}