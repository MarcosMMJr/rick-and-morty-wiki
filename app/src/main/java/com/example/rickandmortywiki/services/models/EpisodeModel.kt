package com.example.rickandmortywiki.services.models

import com.example.rickandmortywiki.services.models.components.CharacterUrlModel

data class EpisodeModel(
    val id: Int,
    val name: String,
    val airDate: String,
    val episode: String,
    val characters: List<CharacterUrlModel>,
    val url: String,
    val created: String
)
data class EpisodeModelResponse(
    val id: Int? = null,
    val name: String? = null,
    val airDate: String? = null,
    val episode: String? = null,
    val characters: List<String>? = null,
    val url: String? = null,
    val created: String? = null
)