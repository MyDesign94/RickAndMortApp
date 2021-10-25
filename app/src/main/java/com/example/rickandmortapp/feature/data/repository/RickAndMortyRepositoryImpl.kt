package com.example.rickandmortapp.feature.data.repository

import com.example.rickandmortapp.feature.data.remote.RickAndMortyApi
import com.example.rickandmortapp.feature.data.remote.dto.Character
import com.example.rickandmortapp.feature.domain.repository.RickAndMortyRepository
import javax.inject.Inject

class RickAndMortyRepositoryImpl @Inject constructor(
    private val api: RickAndMortyApi
): RickAndMortyRepository  {

    override suspend fun getAllCharacters(page: Int): Character {
        return api.getAllCharacters(page = page)
    }
}