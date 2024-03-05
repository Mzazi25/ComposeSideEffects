package com.example.composesideeffects.rememberUpdatedState

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import kotlinx.coroutines.delay

/**
 * Used when we want to cache something and prevent multiple repetitions when launchedEffect we get to the recomposition
 * Example like a timeout on SplashScreen
 */
@Composable
fun RememberUpdatedState(
    onTimeOut:()->Unit
) {
    val updatedTimeOut by rememberUpdatedState(newValue = onTimeOut)
    LaunchedEffect(key1 = true) {
        delay(3000L)
        updatedTimeOut()
    }
}