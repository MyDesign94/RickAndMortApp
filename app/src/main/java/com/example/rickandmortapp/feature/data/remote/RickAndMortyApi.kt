package com.example.rickandmortapp.feature.data.remote

import com.example.rickandmortapp.feature.data.remote.dto.Character
import retrofit2.http.GET
import retrofit2.http.Query

interface RickAndMortyApi {

    @GET("character")
    suspend fun getAllCharacters(
        @Query("page") page: Int = 1
    ): Character

}