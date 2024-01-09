package com.androbrain.mviexample.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ExampleViewModel : ViewModel() {
    private val _state = MutableStateFlow(ExampleState())
    val state = _state.asStateFlow()

    fun handleEvent(event: ExampleEvent) {
        when (event) {
            ExampleEvent.SendClicked -> sendClicked()
            is ExampleEvent.TextChanged -> textChanged(event)
        }
    }

    private fun sendClicked() {
        _state.update { state -> state.copy(isLoading = true) }
        viewModelScope.launch {
            delay(5000L)
            _state.update { state -> state.copy(text = "", isLoading = false) }
        }
    }

    private fun textChanged(data: ExampleEvent.TextChanged) {
        _state.update { state -> state.copy(text = data.text) }
    }
}