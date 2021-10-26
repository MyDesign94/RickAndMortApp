package com.example.rickandmortapp.feature.domain.use_case

import com.example.rickandmortapp.feature.data.remote.dto.toNewResult
import com.example.rickandmortapp.feature.domain.model.NewResult
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
    ): Flow<Resource<List<NewResult>>> = flow {
        try {
            emit(Resource.Loading<List<NewResult>>())
            val pages = repository.getAllCharacters(1).info.pages
            val resultData: MutableList<NewResult> = mutableListOf()
            for (i in 1..pages){
                repository.getAllCharacters(i).results.forEach { resultData += it.toNewResult() }
            }
            emit(Resource.Success<List<NewResult>>(data = resultData))
        } catch (e: HttpException) {
            emit(
                Resource.Error<List<NewResult>>(
                    e.localizedMessage ?: "An unexpected error occurred"
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error<List<NewResult>>(
                    "Couldn't reach server. Check your internet connections"
                )
            )
        }
    }

}