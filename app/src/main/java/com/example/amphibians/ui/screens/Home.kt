package com.example.amphibians.ui.screens

import android.provider.Contacts.Intents.UI
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.amphibians.models.UIState

@Composable
fun HomeScreen(uiState: UIState, modifier: Modifier = Modifier) {
    Surface(modifier.fillMaxWidth()) {
        when(uiState){
            is UIState.Loading -> Text("Loading")
            is UIState.Error -> Text("Error")
            is UIState.Success -> AmphibiansList(amphibians = uiState.amphibians)
        }
    }
}