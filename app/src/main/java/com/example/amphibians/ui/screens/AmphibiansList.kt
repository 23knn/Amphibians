package com.example.amphibians.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.amphibians.models.Amphibian

@Composable
fun AmphibiansList(amphibians : List<Amphibian>, modifier: Modifier = Modifier) {
    LazyColumn {
        items(amphibians) {it -> Text(it.toString())}
    }
}