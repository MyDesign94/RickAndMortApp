package com.example.rickandmortapp.feature.presentation.list_screen.component

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.example.rickandmortapp.R
import com.example.rickandmortapp.feature.presentation.ui.theme.RAMTheme

@ExperimentalCoilApi
@Composable
fun ListScreenLoadingView(
    modifier: Modifier = Modifier,
    backgroundColor: Color = RAMTheme.colors.primaryBackground,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    imageLogo: Int = R.drawable.rick_and_morty_baner,
    imageLoading: Int = R.drawable.rick_gif,
    imageSize: Dp = 250.dp,
    progressIndicatorSize: Dp = 48.dp,
    progressIndicatorColor: Color = RAMTheme.colors.tintColor,
    progressIndicatorWidth: Dp = 4.dp
)
{
    val imageLoader = ImageLoader.invoke(LocalContext.current).newBuilder()
        .componentRegistry {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder(LocalContext.current))
            } else {
                add(GifDecoder())
            }
        }.build()
    
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            horizontalAlignment = horizontalAlignment,
            verticalArrangement = verticalArrangement
        ) {
            Image(
                painterResource(id = imageLogo),
                contentDescription = "logo")
            Image(
                painter = rememberImagePainter(imageLoading, imageLoader = imageLoader),
                modifier = modifier.size(imageSize),
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