package com.example.flightsearchapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.flightsearchapp.data.dao.AirPortDao
import com.example.flightsearchapp.data.entities.AirPort

@Database(entities = [AirPort::class], version = 2, exportSchema = false)
abstract class AirPortDatabase : RoomDatabase() {
    abstract fun airPortDao(): AirPortDao

    companion object {
        @Volatile
        private var Instance: AirPortDatabase? = null

        fun getDatabase(context: Context): AirPortDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    AirPortDatabase::class.java,
                    "flight_search_database"
                )
                    .fallbackToDestructiveMigration()
                    .createFromAsset("database/flight_search.db")
                    .build()
                    .also { Instance = it }
            }
        }
    }
}