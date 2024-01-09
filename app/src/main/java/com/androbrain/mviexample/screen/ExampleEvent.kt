package com.androbrain.mviexample.screen

sealed class ExampleEvent {
    data class TextChanged(val text: String) : ExampleEvent()
    data object SendClicked : ExampleEvent()
    data object MessageShown : ExampleEvent()
}
