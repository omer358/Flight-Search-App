package com.example.flightsearchapp.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearchapp.FlightApplication
import com.example.flightsearchapp.data.FlightRepository
import com.example.flightsearchapp.data.entities.AirPort
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

private const val TAG = "FlightSearchViewModel"
class FlightSearchViewModel(
    private val flightRepository: FlightRepository,
) : ViewModel() {
    var searchQuery by mutableStateOf("")
        private set
    private val _searchResults = MutableStateFlow<List<AirPort>>(emptyList())
    val searchResults: StateFlow<List<AirPort>> get() = _searchResults

    fun onSearchQueryChange(newQuery: String) {
        searchQuery = newQuery
        searchItems(searchQuery)
        Log.i(TAG,searchQuery)
    }

    fun getAllAirports(): Flow<List<AirPort>> {
        return flightRepository.getAllAirPorts()
    }

    private fun searchItems(query: String) {
        Log.i(TAG, "searchItems: is being called")
        viewModelScope.launch {
            flightRepository.searchForAirport(query)
                .collect { items ->
                    _searchResults.value = items
                }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as FlightApplication)
                val flightSearchRepository = application.appContainer.flightRepository
                FlightSearchViewModel(flightSearchRepository)
            }
        }
    }
}