package com.androbrain.mviexample.data

import kotlinx.coroutines.delay

class ExampleRepository {
    suspend fun sendMessage(text: String) {
        // Do networking or local data storage alterations here
        // this delay is just a mock
        delay(3000L)
    }
}
