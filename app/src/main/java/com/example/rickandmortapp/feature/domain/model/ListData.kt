package com.example.rickandmortapp.feature.domain.model

import com.example.rickandmortapp.feature.data.remote.dto.Character
import com.example.rickandmortapp.feature.data.remote.dto.Result

data class ListData(
    val isLoading: Boolean = false,
    val data: List<Result> = emptyList(),
    val error: String = ""
)
