package com.example.rickandmortapp.feature.presentation.list_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.rickandmortapp.R
import com.example.rickandmortapp.feature.presentation.ui.theme.RAMTheme

@Composable
fun ListScreenLoadingView(
    modifier: Modifier = Modifier,
    backgroundColor: Color = RAMTheme.colors.primaryBackground,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    image: Int = R.drawable.rick_and_morty_3,
    imageSize: Dp = 250.dp,
    progressIndicatorSize: Dp = 48.dp,
    progressIndicatorColor: Color = RAMTheme.colors.tintColor,
    progressIndicatorWidth: Dp = 4.dp
)
{
    Box(
        modifier = modifier.fillMaxSize().background(backgroundColor)
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement
        ) {
            Image(
                painterResource(id = image), modifier = modifier.size(imageSize),
                contentDescription = "end"
            )
            Spacer(modifier = modifier.height(30.dp))
            CircularProgressIndicator(
                modifier = modifier.size(progressIndicatorSize), color = progressIndicatorColor,
                strokeWidth = progressIndicatorWidth
            )
        }
    }
}