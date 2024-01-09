package com.androbrain.mviexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androbrain.mviexample.screen.ExampleScreen
import com.androbrain.mviexample.screen.ExampleViewModel
import com.androbrain.mviexample.ui.theme.MVIExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVIExampleTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel: ExampleViewModel = viewModel()
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    ExampleScreen(state = state, sendEvent = viewModel::handleEvent)

                }
            }
        }
    }
}