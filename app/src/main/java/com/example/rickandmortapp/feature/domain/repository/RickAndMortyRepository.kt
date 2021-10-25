package com.example.rickandmortapp.feature.domain.repository

import com.example.rickandmortapp.feature.data.remote.dto.Character

interface RickAndMortyRepository {

    suspend fun getAllCharacters(page: Int) : Character

}