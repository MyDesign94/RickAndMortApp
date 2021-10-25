package com.example.rickandmortapp.feature.domain.use_case

import android.util.Log
import com.example.rickandmortapp.feature.data.remote.dto.Character
import com.example.rickandmortapp.feature.data.remote.dto.Result
import com.example.rickandmortapp.feature.domain.repository.RickAndMortyRepository
import com.example.rickandmortapp.feature.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetAllCharacterUseCase @Inject constructor(
    private val repository: RickAndMortyRepository
) {
    operator fun invoke(
    ): Flow<Resource<List<Result>>> = flow {
        try {
            emit(Resource.Loading<List<Result>>())
            val pages = repository.getAllCharacters(1).info.pages
            val resultData: MutableList<Result> = mutableListOf()
            for (i in 1..pages){
                val data = repository.getAllCharacters(i).results.forEach { resultData += it }
            }
            emit(Resource.Success<List<Result>>(data = resultData))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<Result>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error<List<Result>>(
                    "Couldn't reach server. Check your internet connections"
                )
            )
        }
    }

}