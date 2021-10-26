package com.example.rickandmortapp.di

import com.example.rickandmortapp.core.Constant.BASE_URL
import com.example.rickandmortapp.feature.data.remote.RickAndMortyApi
import com.example.rickandmortapp.feature.data.repository.RickAndMortyRepositoryImpl
import com.example.rickandmortapp.feature.domain.repository.RickAndMortyRepository
import com.example.rickandmortapp.feature.domain.use_case.GetAllCharacterUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRickAndMortyApi(): RickAndMortyApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .build()
            .create(RickAndMortyApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRickAndMortyRepository(api: RickAndMortyApi): RickAndMortyRepository {
        return RickAndMortyRepositoryImpl(api = api)
    }

    @Provides
    @Singleton
    fun provideUseCase(repository: RickAndMortyRepository): GetAllCharacterUseCase {
        return GetAllCharacterUseCase(repository = repository)
    }

}