package com.example.rickandmortapp.feature.presentation.list_screen.model

sealed class ListScreenEvent {
    object EnterScreen : ListScreenEvent()
    object Reload : ListScreenEvent()
    data class ChoseCard(val itemId: Int): ListScreenEvent()
}
