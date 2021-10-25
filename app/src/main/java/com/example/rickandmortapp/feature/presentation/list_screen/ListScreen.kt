package com.example.rickandmortapp.feature.presentation.list_screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.example.rickandmortapp.R
import com.example.rickandmortapp.feature.presentation.list_screen.component.ListScreenDisplayView
import com.example.rickandmortapp.feature.presentation.list_screen.component.ListScreenLoadingView
import com.example.rickandmortapp.feature.presentation.list_screen.component.PersonalCard

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ListScreen(
    navController: NavController,
    viewModel: ListScreenViewModel = hiltViewModel()
){
    val listScreenViewState = viewModel.viewState.observeAsState()

    when(listScreenViewState.value?.isLoading) {
        true -> ListScreenLoadingView()
        false -> ListScreenDisplayView(data = listScreenViewState.value?.data!!) {
            viewModel.obtainEvent(ListScreenEvent.ChoseCard(personalNumber = it.id))
        }
    }

    LaunchedEffect(key1 = Unit, block = {
        viewModel.obtainEvent(ListScreenEvent.FetchInApp)
    })
}