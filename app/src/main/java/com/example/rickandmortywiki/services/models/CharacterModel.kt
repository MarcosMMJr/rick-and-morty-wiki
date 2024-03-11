package com.example.rickandmortywiki.services.models

import com.example.rickandmortywiki.services.models.components.CharacterLocationModel
import com.example.rickandmortywiki.services.models.components.EpisodeUrlModel
import com.example.rickandmortywiki.services.models.components.CharacterOriginModel

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: CharacterOriginModel,
    val location: CharacterLocationModel,
    val image: Int,
    val episode: List<EpisodeUrlModel>,
    val url: String,
    val created: String
    //TODO: change image to String
)
