package com.example.rickandmortapp.feature.presentation.list_screen.component

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.*
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.rickandmortapp.feature.data.remote.dto.Result
import com.example.rickandmortapp.feature.domain.model.NewResult
import com.example.rickandmortapp.feature.presentation.ui.theme.RAMTheme
import com.example.rickandmortapp.feature.presentation.ui.theme.RobotoCondensed

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun PersonalCard(
    item: NewResult,
    modifier: Modifier = Modifier,
    shape: RoundedCornerShape = RoundedCornerShape(10.dp),
    cardBackgroundColor: Color = RAMTheme.colors.secondaryBackground,
    normalPadding: Dp = 10.dp,
    littlePadding: Dp = 4.dp,
    imageSize: Dp = 180.dp,
    elevation: Dp = 3.dp,
){
    var expandedState by remember { mutableStateOf(false) }

    Card(
        shape = shape,
        backgroundColor = cardBackgroundColor,
        modifier = modifier
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(normalPadding),
        elevation = elevation,
        onClick = {
            expandedState = !expandedState
        }
    ) {
        Box(
            modifier = modifier.padding(littlePadding)
        ) {
            Column(
                modifier = modifier.padding(normalPadding)
            ) {
                Row(
                    modifier = modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = item.image,
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = item.name,
                        modifier = Modifier.size(imageSize).clip(shape)
                    )
                    TextEx(item = item.name, modifier = modifier,
                        style = RAMTheme.typography.heading,
                        textAlign = TextAlign.Center
                    )
                }
                if (expandedState) {
                    Column(
                        modifier = modifier.padding(normalPadding)
                    ) {
                        TextEx(prefix = "Name: ", item = item.name, modifier = modifier)
                        TextEx(prefix = "Status: ", item = item.status, modifier = modifier,
                            textColor = if (item.status == "Alive") Color.Green else Color.Red
                        )
                        TextEx(prefix = "Gender: ", item = item.gender, modifier = modifier)
                        TextEx(prefix = "Location: ", item = item.location, modifier = modifier)
                        TextEx(prefix = "Type: ", item = item.type, modifier = modifier)
                        TextEx(prefix = "In which episodes:", style = RAMTheme.typography.heading,
                            textAlign = TextAlign.Center, modifier = modifier
                        )
                        TextEx(prefix = item.episode, modifier = modifier)
                    }
                }
            }
        }
    }
}


@Composable
fun TextEx(
    modifier: Modifier = Modifier,
    prefix: String = "",
    item: String = "",
    style: TextStyle = RAMTheme.typography.body,
    textAlign: TextAlign = TextAlign.Start,
    textColor: Color = RAMTheme.colors.primaryText,
    fontFamily: FontFamily = RobotoCondensed
){
    Text(
        text = "$prefix$item",
        color = textColor,
        style = style,
        fontFamily = fontFamily,
        textAlign = textAlign,
        modifier = modifier
    )
}
