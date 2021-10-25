package com.example.rickandmortapp.feature.presentation.list_screen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.rickandmortapp.R
import com.example.rickandmortapp.feature.presentation.ui.theme.RAMTheme

@Composable
fun ListScreenLoadingView()
{
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(RAMTheme.colors.primaryBackground)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painterResource(id = R.drawable.rick_and_morty_3),
                modifier = Modifier.size(250.dp),
                contentDescription = "end"
            )
            Spacer(modifier = Modifier.height(30.dp))
            CircularProgressIndicator(
                modifier = Modifier.size(48.dp),
                color = RAMTheme.colors.tintColor,
                strokeWidth = 4.dp
            )
        }

    }
}