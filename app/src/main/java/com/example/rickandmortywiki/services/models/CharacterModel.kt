package com.example.rickandmortywiki.services.models

import com.example.rickandmortywiki.services.models.components.CharacterLocationModel
import com.example.rickandmortywiki.services.models.components.CharacterLocationModelResponse
import com.example.rickandmortywiki.services.models.components.CharacterOriginModel
import com.example.rickandmortywiki.services.models.components.CharacterOriginModelResponse
import com.example.rickandmortywiki.services.models.components.EpisodeUrlModel

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

data class CharacterModelResponse(
    val id: Int? = null,
    val name: String? = null,
    val status: String? = null,
    val species: String? = null,
    val type: String? = null,
    val gender: String? = null,
    val origin: CharacterOriginModelResponse? = null,
    val location: CharacterLocationModelResponse? = null,
    val image: String? = null,
    val episode: List<String>? = null,
    val url: String? = null,
    val created: String? = null
)
