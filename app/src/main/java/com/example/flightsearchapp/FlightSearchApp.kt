@file:OptIn(
    ExperimentalMaterial3Api::class
)

package com.example.flightsearchapp

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.flightsearchapp.ui.screens.FlightSearchScreen
import com.example.flightsearchapp.ui.theme.FlightSearchAppTheme

@Composable
fun FlightSearchApp(modifier: Modifier = Modifier) {
    FlightSearchScreen()
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun FlightSearchAppPreview() {
    FlightSearchAppTheme {
        FlightSearchApp()
    }
}