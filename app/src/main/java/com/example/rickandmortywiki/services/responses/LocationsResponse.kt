package com.example.rickandmortywiki.services.responses

import com.example.rickandmortywiki.services.models.LocationModelResponse
import com.example.rickandmortywiki.services.models.components.InfoResponse

data class LocationsResponse(
    val info: InfoResponse? = null,
    val results: List<LocationModelResponse>? = null
)
