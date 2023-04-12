package com.example.amphibians.models

sealed interface UIState {
    data class Success (val amphibians : List<Amphibian>) : UIState
    object Loading : UIState
    object Error : UIState
}