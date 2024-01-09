package com.androbrain.mviexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.compose.viewModel
import com.androbrain.mviexample.data.ExampleRepository
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
                    val viewModel: ExampleViewModel = viewModel(
                        factory = object : ViewModelProvider.Factory {
                            override fun <T : ViewModel> create(
                                modelClass: Class<T>,
                                extras: CreationExtras,
                            ): T {
                                return modelClass.getConstructor(ExampleRepository::class.java)
                                    .newInstance(ExampleRepository())
                            }
                        }
                    )
                    val state by viewModel.state.collectAsStateWithLifecycle()
                    ExampleScreen(state = state, sendEvent = viewModel::handleEvent)

                }
            }
        }
    }
}