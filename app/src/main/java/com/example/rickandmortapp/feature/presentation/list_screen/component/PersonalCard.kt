package com.example.rickandmortapp.feature.presentation.list_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.rickandmortapp.feature.data.remote.dto.Result
import com.example.rickandmortapp.feature.presentation.ui.theme.RAMTheme
import com.example.rickandmortapp.feature.presentation.ui.theme.RobotoCondensed

@ExperimentalCoilApi
@Composable
fun PersonalCard(
    item: Result,
    onItemClick: (Result) -> Unit
){
    Card(
        shape = RoundedCornerShape(10.dp),
        backgroundColor = RAMTheme.colors.secondaryBackground,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        elevation = 3.dp

    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp)
                .clickable { onItemClick.invoke(item) }
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
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
                    modifier = Modifier
                        .size(180.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Text(
                        text = item.name,
                        color = RAMTheme.colors.primaryText,
                        style = RAMTheme.typography.body,
                        fontFamily = RobotoCondensed,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = item.status,
                        color = if(item.status == "Alive") Color.Green else Color.Red,
                        style = RAMTheme.typography.body,
                        fontFamily = RobotoCondensed,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = item.origin.name,
                        color = RAMTheme.colors.secondaryText,
                        style = RAMTheme.typography.body,
                        fontFamily = RobotoCondensed,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )


                }
            }

        }
    }
}

