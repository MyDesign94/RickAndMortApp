package com.example.rickandmortapp.feature.presentation.list_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.hilt.navigation.compose.hiltViewModel
import coil.annotation.ExperimentalCoilApi
import com.example.rickandmortapp.feature.presentation.list_screen.component.ListScreenDisplayView
import com.example.rickandmortapp.feature.presentation.list_screen.component.ListScreenLoadingView

@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ListScreen(
    viewModel: ListScreenViewModel = hiltViewModel()
){
    val listScreenViewState = viewModel.viewState.observeAsState()

    when(listScreenViewState.value?.isLoading) {
        true -> ListScreenLoadingView()
        false -> ListScreenDisplayView(data = listScreenViewState.value?.data!!) {
            viewModel.obtainEvent(ListScreenEvent.ChoseCard(personalNumber = it.id))
        }
    }

    LaunchedEffect(key1 = listScreenViewState, block = {
        viewModel.obtainEvent(ListScreenEvent.FetchInApp)
    })
}