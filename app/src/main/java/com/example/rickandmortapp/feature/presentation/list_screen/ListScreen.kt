package com.example.rickandmortapp.feature.presentation.list_screen

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import coil.annotation.ExperimentalCoilApi
import com.example.rickandmortapp.feature.presentation.list_screen.component.ListScreenDisplayView
import com.example.rickandmortapp.feature.presentation.list_screen.component.ListScreenErrorView
import com.example.rickandmortapp.feature.presentation.list_screen.component.ListScreenLoadingView
import com.example.rickandmortapp.feature.presentation.list_screen.model.ListScreenEvent
import com.example.rickandmortapp.feature.presentation.list_screen.model.ListScreenViewState
import dev.chrisbanes.snapper.ExperimentalSnapperApi

@ExperimentalSnapperApi
@RequiresApi(Build.VERSION_CODES.N)
@ExperimentalMaterialApi
@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ListScreen(
    viewModel: ListScreenViewModel
){
    val listScreenViewState = viewModel.viewState.observeAsState()

    when(val state = listScreenViewState.value) {
        ListScreenViewState.Loading -> ListScreenLoadingView()
        ListScreenViewState.Error -> ListScreenErrorView() {
            viewModel.obtainEvent(ListScreenEvent.Reload)
        }
        is ListScreenViewState.Display -> ListScreenDisplayView(
            data = state.items,
            onItemClick = {
                viewModel.obtainEvent(ListScreenEvent.ChoseCard(it.id))
            }
        )
    }

    LaunchedEffect(key1 = listScreenViewState, block = {
        viewModel.obtainEvent(ListScreenEvent.EnterScreen)
    })
}