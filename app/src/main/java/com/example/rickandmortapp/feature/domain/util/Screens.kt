package com.example.rickandmortapp.feature.domain.util

sealed class Screen(val route: String) {
    object ListScreen : Screen("list_screen")
}