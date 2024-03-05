package com.example.composesideeffects.remembercoroutinescope

import androidx.compose.material3.Button
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * Use this in callback functions, such as onclick, on textChanged
 */

@Composable
fun RememberCoroutineScope(
    snackbarHostState: SnackbarHostState
){
    val scope = rememberCoroutineScope()

    Button(onClick = {
        scope.launch {
            delay(1000L)
            snackbarHostState.showSnackbar("Hello World")
        }
    }) {
        Text(text = "")
    }
}