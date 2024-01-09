package com.androbrain.mviexample.screen

data class ExampleState(
    val text: String = "",
    val isSending: Boolean = false,
    val result: String? = null,
)
