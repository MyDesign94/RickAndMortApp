package com.example.rickandmortapp.feature.presentation.list_screen

sealed class ListScreenEvent {
    object FetchInApp : ListScreenEvent()
    data class ChoseCard(val personalNumber: Int) : ListScreenEvent()
}
