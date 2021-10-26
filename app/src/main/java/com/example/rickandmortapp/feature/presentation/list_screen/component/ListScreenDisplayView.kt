package com.example.rickandmortapp.feature.presentation.list_screen.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.rickandmortapp.R
import com.example.rickandmortapp.feature.data.remote.dto.Result
import com.example.rickandmortapp.feature.presentation.ui.theme.RAMTheme

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun ListScreenDisplayView(
    data: List<Result>,
    onItemClick: (Result) -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = RAMTheme.colors.primaryBackground
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            LazyColumn(
                contentPadding = PaddingValues(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                item {
                    Image(
                        painterResource(id = R.drawable.rick_and_morty_baner),
                        contentDescription = "banner",
                        modifier = Modifier.background(Color.Transparent)
                    )
                }
                items(data) { item ->
                    PersonalCard(
                        modifier = Modifier.fillMaxWidth(),
                        item = item
                    )
                }
                item {
                    Image(
                        painterResource(id = R.drawable.start_logo2),
                        contentDescription = "end"
                    )
                }
            }
        }
    }
}