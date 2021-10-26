package com.example.rickandmortapp.feature.presentation.list_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.rickandmortapp.feature.domain.model.NewResult
import com.example.rickandmortapp.feature.domain.use_case.GetAllCharacterUseCase
import com.example.rickandmortapp.feature.domain.util.EventHandler
import com.example.rickandmortapp.feature.domain.util.Resource
import com.example.rickandmortapp.feature.presentation.list_screen.model.ListScreenEvent
import com.example.rickandmortapp.feature.presentation.list_screen.model.ListScreenViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListScreenViewModel @Inject constructor(
    private val useCase: GetAllCharacterUseCase
): ViewModel(), EventHandler<ListScreenEvent> {

    private val _viewState: MutableLiveData<ListScreenViewState> = MutableLiveData(
        ListScreenViewState.Loading)
    val viewState: LiveData<ListScreenViewState> = _viewState

    @RequiresApi(Build.VERSION_CODES.N)
    override fun obtainEvent(event: ListScreenEvent) {
        when(val currentState = _viewState.value) {
            is ListScreenViewState.Loading -> reduce(event, currentState)
            is ListScreenViewState.Display -> reduce(event, currentState)
            is ListScreenViewState.Error -> reduce(event, currentState)
        }
    }

    private fun reduce(event: ListScreenEvent, currentState: ListScreenViewState.Error) {
        when (event) {
            ListScreenEvent.Reload -> fetchInApp(needsToRefresh = true)
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun reduce(event: ListScreenEvent, currentState: ListScreenViewState.Display) {
        when (event) {
            is ListScreenEvent.ChoseCard -> choseCard(event.itemId, currentState.items)
        }
    }

    private fun reduce(event: ListScreenEvent, currentState: ListScreenViewState.Loading) {
        when (event) {
            ListScreenEvent.EnterScreen -> fetchInApp()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun choseCard(itemId: Int, Data: List<NewResult>) {
        viewModelScope.launch {
            val currentData = Data.toMutableList()
            val item = Data.firstOrNull { it.id == itemId}
            item?.copy(click = !item.click)?.let { currentItem ->
                currentData.replaceAll { oldItem ->
                    if (oldItem.id != itemId) {
                        oldItem
                    } else {
                        currentItem
                    }
                }
            }
            _viewState.postValue(
                ListScreenViewState.Display(
                    items = currentData
                )
            )
        }
    }


    private fun fetchInApp(needsToRefresh: Boolean = false) {
        if (needsToRefresh) {
            _viewState.postValue(ListScreenViewState.Loading)
        }
        viewModelScope.launch {
            try {
                useCase().onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _viewState.postValue(
                                ListScreenViewState.Display(
                                    items = result.data!!
                                )
                            )
                        }
                        is Resource.Loading -> {
                            _viewState.postValue(
                                ListScreenViewState.Loading
                            )
                        }
                        is Resource.Error -> {
                            _viewState.postValue(
                                ListScreenViewState.Error
                            )
                        }
                    }
                }.launchIn(viewModelScope)
            } catch (e: Exception) {
                _viewState.postValue(ListScreenViewState.Error)
            }
        }
    }
}