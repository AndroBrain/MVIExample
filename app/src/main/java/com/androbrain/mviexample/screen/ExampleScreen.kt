package com.androbrain.mviexample.screen

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun ExampleScreen(
    state: ExampleState,
    sendEvent: (ExampleEvent) -> Unit,
) {
    val context = LocalContext.current
    LaunchedEffect(state.message) {
        if (state.message != null) {
            Toast.makeText(context, state.message, Toast.LENGTH_SHORT).show()
            sendEvent(ExampleEvent.MessageShown)
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        if (state.isLoading) {
            CircularProgressIndicator()
        } else {
            OutlinedTextField(
                value = state.text,
                onValueChange = { text ->
                    sendEvent(ExampleEvent.TextChanged(text))
                },
                label = { Text(text = "Message") }
            )

            Button(onClick = { sendEvent(ExampleEvent.SendClicked) }) {
                Text(text = "SEND")
            }
        }
    }
}
