package com.example.flightsearchapp

import android.app.Application
import com.example.flightsearchapp.data.AppContainer
import com.example.flightsearchapp.data.DefaultAppContainer

class FlightApplication: Application() {
    lateinit var appContainer: AppContainer

    override fun onCreate() {
        super.onCreate()
        appContainer = DefaultAppContainer(this)
    }
}