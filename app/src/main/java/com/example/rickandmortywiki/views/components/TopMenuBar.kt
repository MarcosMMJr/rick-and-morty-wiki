package com.example.rickandmortywiki.views.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortywiki.ui.theme.DarkBlue20
import com.example.rickandmortywiki.ui.theme.LightBlue40

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopMenuBar(
    title: String,
    onBackPressed: () -> Unit = {},
    isSearchOn: Boolean = false,
    isFliterOn: Boolean = false,
) {

    Surface(
        modifier = Modifier.fillMaxWidth(),
        shadowElevation = 4.dp,
    ) {
        TopAppBar(title = {
            Text(
                text = title,
                textAlign = TextAlign.Start,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = LightBlue40,
            )
        }, navigationIcon = {
            IconButton(onClick = { onBackPressed() }) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Back button",
                    tint = LightBlue40
                )
            }

        }, colors = TopAppBarDefaults.topAppBarColors(DarkBlue20))
    }

}

@Composable
fun FilterItem(category: String, isSelected: Boolean = false, onFetchCategory: (String) -> Unit) {

}

@Composable
fun FilterMenu() {


}
