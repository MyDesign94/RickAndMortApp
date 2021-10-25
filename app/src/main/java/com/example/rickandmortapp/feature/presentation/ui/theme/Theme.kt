package com.example.rickandmortapp.feature.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmortapp.R

@Composable
fun MainTheme(
    style: RAMStyle = RAMStyle.Purple,
    textSize: RAMSize = RAMSize.Medium,
    paddingSize: RAMSize = RAMSize.Medium,
    corners: RAMCorners = RAMCorners.Rounded,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = when (darkTheme) {
        true -> {
            when (style) {
                RAMStyle.Purple -> purpleDarkPalette
                RAMStyle.Blue -> blueDarkPalette
                RAMStyle.Orange -> orangeDarkPalette
                RAMStyle.Red -> redDarkPalette
                RAMStyle.Green -> greenDarkPalette
            }
        }
        false -> {
            when (style) {
                RAMStyle.Purple -> purpleLightPalette
                RAMStyle.Blue -> blueLightPalette
                RAMStyle.Orange -> orangeLightPalette
                RAMStyle.Red -> redLightPalette
                RAMStyle.Green -> greenLightPalette
            }
        }
    }

    val typography = RAMTypography(
        heading = TextStyle(
            fontSize = when (textSize) {
                RAMSize.Small -> 24.sp
                RAMSize.Medium -> 28.sp
                RAMSize.Big -> 32.sp
            },
            fontWeight = FontWeight.Bold
        ),
        body = TextStyle(
            fontSize = when (textSize) {
                RAMSize.Small -> 14.sp
                RAMSize.Medium -> 16.sp
                RAMSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Normal
        ),
        toolbar = TextStyle(
            fontSize = when (textSize) {
                RAMSize.Small -> 14.sp
                RAMSize.Medium -> 16.sp
                RAMSize.Big -> 18.sp
            },
            fontWeight = FontWeight.Medium
        ),
        caption = TextStyle(
            fontSize = when (textSize) {
                RAMSize.Small -> 10.sp
                RAMSize.Medium -> 12.sp
                RAMSize.Big -> 14.sp
            }
        )
    )

    val shapes = RAMShape(
        padding = when (paddingSize) {
            RAMSize.Small -> 12.dp
            RAMSize.Medium -> 16.dp
            RAMSize.Big -> 20.dp
        },
        cornersStyle = when (corners) {
            RAMCorners.Flat -> RoundedCornerShape(0.dp)
            RAMCorners.Rounded -> RoundedCornerShape(8.dp)
        }
    )

    val images = RAMImage(
        mainIcon = if (darkTheme) R.drawable.ic_baseline_mood_24 else R.drawable.ic_baseline_mood_bad_24,
        mainIconDescription = if (darkTheme) "Good Mood" else "Bad Mood"
    )

    CompositionLocalProvider(
        LocalRAMColors provides colors,
        LocalRAMTypography provides typography,
        LocalRAMShape provides shapes,
        LocalRAMImage provides images,
        content = content
    )
}