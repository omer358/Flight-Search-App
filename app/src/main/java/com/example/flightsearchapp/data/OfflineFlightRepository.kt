package com.example.flightsearchapp.data

import android.util.Log
import com.example.flightsearchapp.data.dao.AirPortDao
import com.example.flightsearchapp.data.entities.AirPort
import kotlinx.coroutines.flow.Flow

private const val TAG = "OfflineFlightRepository"
class OfflineFlightRepository(
    private val airPortDao: AirPortDao,
) : FlightRepository {
    override fun searchForAirport(name: String): Flow<List<AirPort>> {
        Log.i(TAG, name)
        return airPortDao.findAirPorts("%$name%")
    }

    override fun getAllAirPorts(): Flow<List<AirPort>> {
        return airPortDao.getAllAirPorts()
    }
}