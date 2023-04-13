package com.example.amphibians.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.amphibians.R

@Composable
fun AppBar(modifier: Modifier = Modifier) {
    TopAppBar() {
        Text(text = stringResource(id = R.string.app_name), modifier = Modifier.padding(start = 8.dp))
    }
}