package com.example.rickandmortywiki.services.models

import com.example.rickandmortywiki.services.models.components.EpisodeUrlModel
import com.example.rickandmortywiki.services.models.components.OriginModel

data class CharacterModel(
    val id: Int,
    val name: String,
    val status: String,
    val species: String,
    val type: String,
    val gender: String,
    val origin: OriginModel,
    val location: LocationModel,
    val image: String,
    val episode: List<EpisodeUrlModel>,
    val url: String,
    val created: String

)
