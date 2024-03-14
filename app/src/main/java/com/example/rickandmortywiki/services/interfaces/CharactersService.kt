package com.example.rickandmortywiki.services.interfaces

import com.example.rickandmortywiki.services.responses.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET

interface CharactersService {
    @GET("character/")
    fun getCharacters(): Call<CharactersResponse>

    @GET("character/{id}")
    fun getCharacterById(id: Int): Call<CharactersResponse>
}