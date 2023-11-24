@file:OptIn(
    ExperimentalMaterial3Api::class
)

package com.example.flightsearchapp

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.flightsearchapp.ui.screens.FlightSearchScreen
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme

@Composable
fun FlightSearchApp(modifier: Modifier = Modifier) {
    FlightSearchScreen(
        modifier
            .padding(16.dp)
            .wrapContentSize())
}


@Preview
@Composable
fun FlightSearchAppPreview() {
    FlightSearchAppTheme(darkTheme = true) {
        FlightSearchApp()
    }
}