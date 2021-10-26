package com.example.rickandmortapp.feature.domain.model

import com.example.rickandmortapp.feature.data.remote.dto.Location
import com.example.rickandmortapp.feature.data.remote.dto.Origin
import com.example.rickandmortapp.feature.data.remote.dto.Result

data class ListData(
    val isLoading: Boolean = false,
    val data: List<NewResult> = emptyList(),
    val error: String = ""
)

data class NewResult(
    val created: String,
    val episode: String,
    val gender: String,
    val id: Int,
    val image: String,
    val location: String,
    val name: String,
    val origin: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String,
    val click: Boolean
)
