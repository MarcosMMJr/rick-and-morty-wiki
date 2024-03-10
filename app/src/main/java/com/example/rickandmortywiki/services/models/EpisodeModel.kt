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
