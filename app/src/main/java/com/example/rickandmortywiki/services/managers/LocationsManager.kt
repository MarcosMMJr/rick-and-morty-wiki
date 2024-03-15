package com.example.rickandmortywiki.services.managers

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.rickandmortywiki.services.Api
import com.example.rickandmortywiki.services.responses.CharactersResponse
import com.example.rickandmortywiki.services.responses.EpisodesResponse
import com.example.rickandmortywiki.services.responses.LocationsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationsManager {
    private val _locationsResponse = mutableStateOf(LocationsResponse())

    val locationsResponse: State<LocationsResponse>
        @Composable get() = remember {
            _locationsResponse
        }

    init {
        getLocations()
    }

    private fun getLocations() {
        val service = Api.locationService.getLocations()
        service.enqueue(object : Callback<LocationsResponse> {

            override fun onResponse(
                call: Call<LocationsResponse>,
                response: Response<LocationsResponse>
            ) {
                if (response.isSuccessful) {
                    _locationsResponse.value = response.body()!!
                    Log.d("Locations", "Success: ${_locationsResponse.value}")
                } else {
                    Log.d("LocationsManagerError", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<LocationsResponse>, t: Throwable) {
                Log.d("LocationsManagerError", "Error: ${t.message}")
            }
        })
    }
}