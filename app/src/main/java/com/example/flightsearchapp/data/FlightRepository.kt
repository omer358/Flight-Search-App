package com.example.flightsearchapp.data

import com.example.flightsearchapp.data.entities.AirPort
import kotlinx.coroutines.flow.Flow

interface FlightRepository {

    fun searchForAirport(name: String): Flow<List<AirPort>>
}