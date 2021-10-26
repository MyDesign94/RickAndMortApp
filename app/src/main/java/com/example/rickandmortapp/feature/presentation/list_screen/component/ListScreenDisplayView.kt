package com.example.rickandmortapp.feature.presentation.list_screen.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.rickandmortapp.R
import com.example.rickandmortapp.feature.domain.model.NewResult
import com.example.rickandmortapp.feature.presentation.ui.theme.RAMTheme

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun ListScreenDisplayView(
    modifier: Modifier = Modifier,
    background: Color = RAMTheme.colors.primaryBackground,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    standardPadding: Dp = 10.dp,
    imageTop: Int = R.drawable.rick_and_morty_baner,
    imageBottom: Int = R.drawable.start_logo2,
    data: List<NewResult>,
    onItemClick: (NewResult) -> Unit
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = background
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = horizontalAlignment
        ) {
            LazyColumn(
                contentPadding = PaddingValues(standardPadding),
                horizontalAlignment = horizontalAlignment
            ) {
                item {
                    Image(
                        painterResource(id = imageTop),
                        contentDescription = "banner"
                    )
                }
                items(data) { item ->
                    PersonalCard(
                        modifier = modifier.fillMaxWidth(),
                        item = item,
                        onItemClick = onItemClick
                    )
                }
                item {
                    Image(
                        painterResource(id = imageBottom),
                        contentDescription = "end"
                    )
                }
            }
        }
    }
}