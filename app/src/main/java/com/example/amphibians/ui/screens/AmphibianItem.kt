package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.amphibians.models.Amphibian
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

@Composable
fun AmphibianItem(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier.padding(bottom = 10.dp),
        elevation = 4.dp
    ) {
        Column(modifier = modifier) {
            AmphibianDescription(amphibian, modifier)
            AmphibianImage(amphibian.img_src, modifier)
        }
    }
}

@Composable
fun AmphibianImage(imageUrl: String, modifier: Modifier = Modifier ){
    AsyncImage(
        model = imageUrl,
        contentDescription = "amphibian",
        contentScale = ContentScale.FillBounds,
        modifier = modifier
    )
}

@Composable
fun AmphibianDescription(amphibian: Amphibian, modifier: Modifier = Modifier) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier =  modifier.padding(10.dp)
    ){
        Text(
            text = amphibian.name,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
        Text(amphibian.description)
    }
}