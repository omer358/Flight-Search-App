package com.example.flightsearchapp.data

import com.example.flightsearchapp.data.dao.AirPortDao
import com.example.flightsearchapp.data.entities.AirPort
import kotlinx.coroutines.flow.Flow

class OfflineFlightRepository(
    private val airPortDao: AirPortDao,
) : FlightRepository {
    override fun searchForAirport(name: String): Flow<List<AirPort>> {
        return airPortDao.findAirPorts(name)
    }

    override fun getAllAirPorts(): Flow<List<AirPort>> {
        return airPortDao.getAllAirPorts()
    }
}