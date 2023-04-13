package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil.compose.AsyncImage
import com.example.amphibians.models.Amphibian

@Composable
fun AmphibianItem(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Card() {
        Row() {
            AmphibianImage(amphibian.img_src)
            AmphibianDescription(amphibian)
        }
    }
}

@Composable
fun AmphibianImage(imageUrl: String, modifier: Modifier = Modifier ){
    AsyncImage(model = imageUrl, contentDescription = "amphibian")
}

@Composable
fun AmphibianDescription(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Row{
        Text(amphibian.name)
        Text(amphibian.description)
    }
}