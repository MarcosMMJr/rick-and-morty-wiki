package com.example.rickandmortywiki.services.models.components

data class CharacterOriginModel(
    val name: String,
    val url: String
)

data class CharacterOriginModelResponse(
    val name: String? = null,
    val url: String? = null
)
