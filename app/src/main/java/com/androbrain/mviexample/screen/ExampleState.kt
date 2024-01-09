package com.androbrain.mviexample.screen

data class ExampleState(
    val text: String = "",
    val isLoading: Boolean = false,
    val message: String? = null,
)
