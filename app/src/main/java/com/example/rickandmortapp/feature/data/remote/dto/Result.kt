package com.example.rickandmortapp.feature.data.remote.dto

import com.example.rickandmortapp.feature.domain.model.NewResult

data class Result(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Origin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun Result.toNewResult(): NewResult {
    var allEpisode = ""
    episode.forEach { episode -> allEpisode += "${episode.takeLastWhile { it.isDigit() }} " }
    return NewResult(
        episode =allEpisode,
        gender =gender,
        id =id,
        image =image,
        location =location.name,
        name =name,
        origin =origin.name,
        status =status,
        type =type,
        click = false
    )
}
