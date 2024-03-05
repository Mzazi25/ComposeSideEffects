package com.example.composesideeffects.sideeffect

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect

/**
 * Used when we want to trigger something after a recomposition has happened
 */
@Composable
fun SideEffectScreen(
    nonComposeCounter:Int
) {
    SideEffect {
        println("Successfully recomposed, updating $nonComposeCounter")
    }
}