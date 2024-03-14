package com.example.rickandmortywiki.services.interfaces

import com.example.rickandmortywiki.services.responses.CharactersResponse
import com.example.rickandmortywiki.services.responses.EpisodesResponse
import retrofit2.Call
import retrofit2.http.GET

interface EpisodesService {
    @GET("episode/")
    fun getEpisodes(): Call<EpisodesResponse>

}