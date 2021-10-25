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
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.rickandmortapp.feature.data.remote.dto.Result
import com.example.rickandmortapp.feature.presentation.ui.theme.RAMTheme
import com.example.rickandmortapp.feature.presentation.ui.theme.RobotoCondensed

@ExperimentalFoundationApi
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun PersonalCard(
    item: Result
){
    var expandedState by remember { mutableStateOf(false) }


    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = RAMTheme.colors.secondaryBackground,
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 300,
                    easing = LinearOutSlowInEasing
                )
            )
            .padding(10.dp),
        elevation = 3.dp,
        onClick = {
            expandedState = !expandedState
        }

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = item.image,
                            builder = {
                                crossfade(true)
                            }
                        ),
                        contentDescription = item.name,
                        modifier = Modifier
                            .size(180.dp)
                            .clip(RoundedCornerShape(10.dp))
                    )
                    if (!expandedState) {
                        Column(
                            modifier = Modifier
                                .padding(start = 4.dp)
                                .fillMaxSize(),
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Top
                        ) {
                            Text(
                                text = "Name: ${item.name}",
                                color = RAMTheme.colors.primaryText,
                                style = RAMTheme.typography.body,
                                fontFamily = RobotoCondensed,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.fillMaxWidth()
                            )
                            Text(
                                text = "status: ${item.status}",
                                color = if(item.status == "Alive") Color.Green else Color.Red,
                                style = RAMTheme.typography.body,
                                fontFamily = RobotoCondensed,
                                textAlign = TextAlign.Start,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }

                }
                if (expandedState) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp),
                        horizontalAlignment = Alignment.Start
                    ) {
                        Text(
                            text = "Name: ${item.name}",
                            color = RAMTheme.colors.primaryText,
                            style = RAMTheme.typography.body,
                            fontFamily = RobotoCondensed,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "status: ${item.status}",
                            color = if(item.status == "Alive") Color.Green else Color.Red,
                            style = RAMTheme.typography.body,
                            fontFamily = RobotoCondensed,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "Gender: ${item.gender}",
                            color = RAMTheme.colors.primaryText,
                            style = RAMTheme.typography.body,
                            fontFamily = RobotoCondensed,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "Location: ${item.location.name}",
                            color = RAMTheme.colors.primaryText,
                            style = RAMTheme.typography.body,
                            fontFamily = RobotoCondensed,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "Type: ${item.type}",
                            color = RAMTheme.colors.primaryText,
                            style = RAMTheme.typography.body,
                            fontFamily = RobotoCondensed,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "In which episodes",
                            color = RAMTheme.colors.primaryText,
                            style = RAMTheme.typography.heading,
                            fontFamily = RobotoCondensed,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth()
                        )
                        var text = ""
                        item.episode.forEach { episode ->
                            text += "${episode.takeLastWhile { it.isDigit() }} "
                        }
                        Text(
                            text = text,
                            color = RAMTheme.colors.primaryText,
                            style = RAMTheme.typography.body,
                            fontFamily = RobotoCondensed,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }

        }
    }
}

