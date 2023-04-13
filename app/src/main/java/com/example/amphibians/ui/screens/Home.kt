package com.example.amphibians.ui.screens

import android.provider.Contacts.Intents.UI
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.amphibians.models.UIState

@Composable
fun HomeScreen(uiState: UIState, modifier: Modifier = Modifier) {
    Scaffold(topBar = {AppBar(modifier = modifier)}) { padding ->
        Surface(modifier.padding(padding)) {
            when(uiState){
                is UIState.Loading -> Text("Loading")
                is UIState.Error -> Text("Error")
                is UIState.Success -> AmphibiansList(amphibians = uiState.amphibians, modifier.padding(10.dp))
            }
        }
    }

}