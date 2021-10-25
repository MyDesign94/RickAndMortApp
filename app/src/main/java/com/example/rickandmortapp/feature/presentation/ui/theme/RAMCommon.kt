package com.example.rickandmortapp.feature.presentation.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp

data class RAMColors(
    val primaryText: Color,
    val primaryBackground: Color,
    val secondaryText: Color,
    val secondaryBackground: Color,
    val tintColor: Color,
    val controlColor: Color,
    val errorColor: Color
)

data class RAMTypography(
    val heading: TextStyle,
    val body: TextStyle,
    val toolbar: TextStyle,
    val caption: TextStyle
)

data class RAMShape(
    val padding: Dp,
    val cornersStyle: Shape
)

data class RAMImage(
    val mainIcon: Int,
    val mainIconDescription: String
)

object RAMTheme {
    val colors: RAMColors
        @Composable
        get() = LocalRAMColors.current

    val typography: RAMTypography
        @Composable
        get() = LocalRAMTypography.current

    val shapes: RAMShape
        @Composable
        get() = LocalRAMShape.current

    val images: RAMImage
        @Composable
        get() = LocalRAMImage.current
}

enum class RAMStyle {
    Purple, Orange, Blue, Red, Green
}

enum class RAMSize {
    Small, Medium, Big
}

enum class RAMCorners {
    Flat, Rounded
}

val LocalRAMColors = staticCompositionLocalOf<RAMColors> {
    error("No colors provided")
}

val LocalRAMTypography = staticCompositionLocalOf<RAMTypography> {
    error("No font provided")
}

val LocalRAMShape = staticCompositionLocalOf<RAMShape> {
    error("No shapes provided")
}

val LocalRAMImage = staticCompositionLocalOf<RAMImage> {
    error("No images provided")
}