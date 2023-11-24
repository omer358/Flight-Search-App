package com.example.flightsearchapp.data

import android.content.Context

interface AppContainer{
    val flightRepository: FlightRepository
}


class DefaultAppContainer(
    private val context: Context
): AppContainer{
    override val flightRepository: FlightRepository by lazy {
        OfflineFlightRepository(AirPortDatabase.getDatabase(context).airPortDao())
    }
}