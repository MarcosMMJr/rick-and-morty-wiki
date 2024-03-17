package com.example.rickandmortywiki.services.interfaces

import com.example.rickandmortywiki.services.responses.CharactersResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {
    @GET("character/")
    fun getCharacters(@Query("page") pageIndex: Int): Call<CharactersResponse>

}