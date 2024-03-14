package com.example.rickandmortywiki.services.managers

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.rickandmortywiki.services.Api
import com.example.rickandmortywiki.services.responses.CharactersResponse
import com.example.rickandmortywiki.services.responses.EpisodesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodesManager {
    private val _episodesResponse = mutableStateOf(EpisodesResponse())

    val episodesResponse: State<EpisodesResponse>
        @Composable get() = remember {
            _episodesResponse
        }

    init {
        getEpisodes()
    }

    private fun getEpisodes() {
        val service = Api.episodeService.getEpisodes()
        service.enqueue(object : Callback<EpisodesResponse> {

            override fun onResponse(
                call: Call<EpisodesResponse>,
                response: Response<EpisodesResponse>
            ) {
                if (response.isSuccessful) {
                    _episodesResponse.value = response.body()!!
                    Log.d("Episodes", "Success: ${_episodesResponse.value}")
                } else {
                    Log.d("EpisodesManagerError", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<EpisodesResponse>, t: Throwable) {
                Log.d("EpisodesManagerError", "Error: ${t.message}")
            }
        })
    }
}