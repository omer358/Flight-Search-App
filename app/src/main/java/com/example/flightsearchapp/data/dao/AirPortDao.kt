package com.example.flightsearchapp.data.dao

import androidx.room.Dao
import androidx.room.Query
import com.example.flightsearchapp.data.entities.AirPort
import kotlinx.coroutines.flow.Flow

@Dao
interface AirPortDao {
    @Query("SELECT * FROM airport WHERE name LIKE :name")
    fun findAirPorts(name: String): Flow<List<AirPort>>

    @Query("SELECT * FROM AIRPORT")
    fun getAllAirPorts(): Flow<List<AirPort>>

}