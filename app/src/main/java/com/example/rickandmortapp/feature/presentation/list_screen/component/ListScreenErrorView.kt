package com.example.rickandmortapp.feature.presentation.list_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.rickandmortapp.R
import com.example.rickandmortapp.feature.presentation.ui.theme.RAMTheme

@Composable
fun ListScreenErrorView(
    modifier: Modifier = Modifier,
    backgroundColor: Color = RAMTheme.colors.primaryBackground,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.Center,
    imageLogo: Int = R.drawable.rick_and_morty_baner,
    imageError: Int = R.drawable.rick_morty_error,
    standardSize: Dp = 250.dp,
    textError: String = stringResource(R.string.daily_error_loading),
    textAlign: TextAlign = TextAlign.Center,
    buttonColors: ButtonColors = ButtonDefaults.buttonColors(RAMTheme.colors.errorColor),
    buttonTextStyle: TextStyle = RAMTheme.typography.heading,
    buttonText: String = stringResource(R.string.refresh),
    onButtonClick: () -> Unit
) {
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
                painterResource(id = imageError),
                modifier = modifier.size(standardSize),
                contentDescription = "end"
            )
            Spacer(modifier = modifier.height(30.dp))
            TextEx(
                text = textError,
                modifier = modifier.width(standardSize),
                textAlign = textAlign
            )
            Spacer(modifier = modifier.height(30.dp))
            Button(
                onClick = { onButtonClick() },
                modifier = modifier.width(standardSize),
                colors = buttonColors
            ) {
                TextEx(
                    text = buttonText,
                    style = buttonTextStyle,
                    modifier = modifier.fillMaxWidth(),
                    textAlign = textAlign
                )
            }
        }
    }
}