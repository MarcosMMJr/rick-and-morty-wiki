package com.example.rickandmortywiki.services.interfaces

import com.example.rickandmortywiki.services.responses.LocationsResponse
import retrofit2.Call
import retrofit2.http.GET

interface LocationsService {
    @GET("location/")
    fun getLocations(): Call<LocationsResponse>

}