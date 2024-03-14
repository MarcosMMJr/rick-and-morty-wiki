package com.example.rickandmortywiki.services.models.components

data class CharacterLocationModel(
    val name: String,
    val url: String
)

data class CharacterLocationModelResponse(
    val name: String? = null,
    val url: String? = null
)
