@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.flightsearchapp.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearchapp.data.entities.AirPort


private const val TAG = "FlightSearchScreen"
@Composable
fun FlightSearchScreen(
    viewModel: FlightSearchViewModel = viewModel(factory = FlightSearchViewModel.Factory),
    modifier: Modifier = Modifier,
) {
    val searchResults by viewModel.searchResults.collectAsStateWithLifecycle()
    Log.i(TAG, searchResults.toString())
    val airports by viewModel.getAllAirports().collectAsState(emptyList())
    SearchBarExample(
        allAirports = airports,
        searchQuery = viewModel.searchQuery,
        searchResults = searchResults,
        onSearchQueryChange = { viewModel.onSearchQueryChange(it) }
    )
}


@Composable
fun SearchBarExample(
    searchQuery: String,
    searchResults: List<AirPort>,
    onSearchQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    allAirports: List<AirPort>,
) {
    var active: Boolean by remember { mutableStateOf(false) }
    Box(Modifier.fillMaxSize()) {
        SearchBar(
            query = searchQuery,
            onQueryChange = onSearchQueryChange,
            onSearch = { active = true },
            active = active,
            onActiveChange = {
                active = it
            },
            modifier = modifier.fillMaxWidth(),
            placeholder = { Text("Hinted search text") },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) }
        ) {
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(32.dp),
                contentPadding = PaddingValues(16.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(
                    count = searchResults.size,
                    key = { index -> searchResults[index].id },
                    itemContent = { index ->
                        val airport = searchResults[index]
                        AirPortListItem(airport = airport)
                    }
                )
            }
        }
    }
//    LazyColumn(
//        verticalArrangement = Arrangement.spacedBy(8.dp)
//    ) {
//        items(
//            items = allAirports,
//            key = { airport -> airport.id }
//        )  {
//            Text(
//              text = it.name,
//                Modifier
//                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp)
//            )
//        }
//    }
}

@Composable
fun AirPortListItem(airport: AirPort, modifier: Modifier = Modifier) {
    Card (
        modifier = modifier.fillMaxWidth(),

    ){
        Text(text = airport.name)
    }
}
