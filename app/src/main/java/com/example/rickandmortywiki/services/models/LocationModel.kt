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

data class LocationModelResponse(
    val id: Int? = null,
    val name: String? = null,
    val type: String? = null,
    val dimension: String? = null,
    val residents: List<String>? = null,
    val url: String? = null,
    val created: String? = null
)
