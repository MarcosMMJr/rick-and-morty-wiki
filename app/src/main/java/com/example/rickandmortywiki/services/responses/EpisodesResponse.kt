package com.example.rickandmortywiki.services.responses

import com.example.rickandmortywiki.services.models.EpisodeModelResponse
import com.example.rickandmortywiki.services.models.components.InfoResponse

data class EpisodesResponse(
    val info: InfoResponse? = null,
    val results: List<EpisodeModelResponse>? = null
)
