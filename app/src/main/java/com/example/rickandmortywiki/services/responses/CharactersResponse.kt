package com.example.rickandmortywiki.services.responses

import com.example.rickandmortywiki.services.models.CharacterModelResponse
import com.example.rickandmortywiki.services.models.components.InfoResponse

data class CharactersResponse(
    val info: InfoResponse? = null,
    val results: List<CharacterModelResponse>? = null
)
