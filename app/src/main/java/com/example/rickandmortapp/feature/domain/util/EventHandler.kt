package com.example.rickandmortapp.feature.domain.util

interface EventHandler<T> {
    fun obtainEvent(event: T)
}