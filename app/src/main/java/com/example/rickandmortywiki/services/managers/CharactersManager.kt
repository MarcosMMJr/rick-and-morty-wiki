package com.example.rickandmortywiki.services.managers

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.rickandmortywiki.services.Api
import com.example.rickandmortywiki.services.responses.CharactersResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersManager {
    private val _charactersResponse = mutableStateOf(CharactersResponse())

    val charactersResponse: State<CharactersResponse>
        @Composable get() = remember {
            _charactersResponse
        }

    init {
        getCharacters()
    }

    private fun getCharacters() {
        val service = Api.characterService.getCharacters()
        service.enqueue(object : Callback<CharactersResponse> {

            override fun onResponse(
                call: Call<CharactersResponse>,
                response: Response<CharactersResponse>
            ) {
                if (response.isSuccessful) {
                    _charactersResponse.value = response.body()!!
                    Log.d("Characters", "Success: ${_charactersResponse.value}")
                } else {
                    Log.d("CharactersManagerError", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<CharactersResponse>, t: Throwable) {
                Log.d("CharactersManagerError", "Error: ${t.message}")
            }
        })
    }
}