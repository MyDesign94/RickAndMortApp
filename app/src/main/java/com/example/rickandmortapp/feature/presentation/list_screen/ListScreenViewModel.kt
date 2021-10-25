package com.example.rickandmortapp.feature.presentation.list_screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortapp.feature.domain.model.ListData
import com.example.rickandmortapp.feature.domain.use_case.GetAllCharacterUseCase
import com.example.rickandmortapp.feature.domain.util.EventHandler
import com.example.rickandmortapp.feature.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val useCase: GetAllCharacterUseCase
): ViewModel(), EventHandler<ListScreenEvent> {

    private val _viewState: MutableLiveData<ListData> = MutableLiveData(ListData())
    val viewState: LiveData<ListData> = _viewState

    private val _data = mutableStateOf(ListData())
    val data: State<ListData> = _data

    init {
        getData()
    }

    override fun obtainEvent(event: ListScreenEvent) {
        when(event) {
            ListScreenEvent.FetchInApp -> fetchInApp()
            is ListScreenEvent.ChoseCard -> choseCard(personalNumber = event.personalNumber)
        }
    }

    private fun choseCard(personalNumber: Int) {

    }

    private fun fetchInApp() {
        useCase().onEach { result ->
            Log.e("getData", "started")
            when(result) {
                is Resource.Success -> {
                    _viewState.postValue(
                        ListData(
                            isLoading = false,
                            data = result.data!!
                        )
                    )
                }
                is Resource.Loading -> {
                    _viewState.postValue(ListData(isLoading = true))
                }
                is Resource.Error -> {
                    _viewState.postValue(ListData(error = result.message?: "An unexpected error occured"))
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun getData() {
        Log.e("getData", "started")
        useCase().onEach { result ->
            when(result) {
                is Resource.Success -> {
                    _data.value = data.value.copy(
                        data = result.data!!,
                        isLoading = false
                    )
                    Log.e("data_result", result.data.toString())
                }
                is Resource.Loading -> {
                    _data.value = data.value.copy(
                        isLoading = true
                    )
                    Log.e("data_loading", "true")
                }
                is Resource.Error -> {
                    _data.value = data.value.copy(
                        error = result.message?: "An unexpected error occured"
                    )
                    Log.e("data_error", result.message.toString())
                }
            }
        }.launchIn(viewModelScope)
    }


}