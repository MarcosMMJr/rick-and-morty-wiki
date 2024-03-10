package com.example.rickandmortywiki.services.models

import com.example.rickandmortywiki.services.models.components.CharacterUrlModel

data class LocationModel(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<CharacterUrlModel>,
    val url: String,
    val created: String
)
