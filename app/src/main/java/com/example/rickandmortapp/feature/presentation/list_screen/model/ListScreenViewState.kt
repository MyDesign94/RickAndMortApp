package com.example.rickandmortapp.feature.presentation.list_screen.model

import com.example.rickandmortapp.feature.domain.model.NewResult

sealed class ListScreenViewState {
    object Loading : ListScreenViewState()
    data class Display(val items: List<NewResult>) : ListScreenViewState()
    object Error : ListScreenViewState()
}
