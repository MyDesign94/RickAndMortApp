package com.example.rickandmortapp.feature.domain.model

data class NewResult(
    val episode: String,
    val gender: String,
    val id: Int,
    val image: String,
    val location: String,
    val name: String,
    val origin: String,
    val status: String,
    val type: String,
    val click: Boolean
)
