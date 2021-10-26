package com.example.rickandmortapp.feature.presentation.list_screen.component

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
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
import com.example.rickandmortapp.feature.domain.model.NewResult
import com.example.rickandmortapp.feature.presentation.ui.theme.RAMTheme
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior

@ExperimentalSnapperApi
@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun ListScreenDisplayView(
    modifier: Modifier = Modifier,
    background: Color = RAMTheme.colors.primaryBackground,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    standardPadding: PaddingValues = PaddingValues(10.dp),
    imageTop: Int = R.drawable.rick_and_morty_baner,
    imageBottom: Int = R.drawable.start_logo2,
    data: List<NewResult>,
    onItemClick: (NewResult) -> Unit
) {
    val lazyListState = rememberLazyListState()

    Surface(
        modifier = modifier.fillMaxSize(),
        color = background
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = horizontalAlignment
        ) {
            LazyColumn(
                state = lazyListState,
                flingBehavior = rememberSnapperFlingBehavior(
                    lazyListState = lazyListState,
                    endContentPadding = standardPadding.calculateBottomPadding()
                ),
                contentPadding = standardPadding,
                verticalArrangement = Arrangement.spacedBy(4.dp),
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