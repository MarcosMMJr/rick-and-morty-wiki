package com.example.rickandmortywiki.services

import com.example.rickandmortywiki.services.interfaces.CharactersService
import com.example.rickandmortywiki.services.interfaces.EpisodesService
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object Api {

    private const val BASE_URL = "https://rickandmortyapi.com/api/"

    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
        .build()

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .baseUrl(BASE_URL)
        .build()

    val characterService: CharactersService by lazy {
        retrofit.create(CharactersService::class.java)
    }

    val episodeService: EpisodesService by lazy {
        retrofit.create(EpisodesService::class.java)
    }
}