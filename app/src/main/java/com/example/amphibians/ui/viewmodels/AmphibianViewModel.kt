package com.example.amphibians.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.amphibians.AmphibianApplication
import com.example.amphibians.data.AmphibianRepository
import com.example.amphibians.models.Amphibian
import com.example.amphibians.models.UIState
import kotlinx.coroutines.launch

class AmphibianViewModel(private val amphibianRepository: AmphibianRepository) : ViewModel() {
    var uiState : UIState by mutableStateOf(UIState.Loading)
        private set

    init {
        getAmphibians()
    }
    fun getAmphibians() {
        viewModelScope.launch {
            uiState = UIState.Loading
            uiState = try {
                UIState.Success(amphibianRepository.getAmphibians())
            }catch (e: Error){
                UIState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                // we want to get the repository variable in the application. then inject it into an instance of the view model and return it. thus the
                // ... factory will have returned a view model with the repository injected
                val application =  (this[APPLICATION_KEY] as AmphibianApplication) // get the app
                val repository = application.container.amphibianRepository // extract the repository
                AmphibianViewModel(amphibianRepository = repository) // inject
            }
        }
    }
}