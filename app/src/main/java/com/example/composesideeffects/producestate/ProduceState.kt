package com.example.composesideeffects.producestate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import kotlinx.coroutines.delay
import androidx.compose.runtime.State

@Composable
fun produceState(counter:Int):State<Int> {
    var value = 0
    return produceState(initialValue = 0) {
        while(value <counter){
            delay(1000L)
            value ++
        }
    }
}