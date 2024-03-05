package com.example.composesideeffects.disposableeffect

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleEventObserver
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner

/**
 * Used when we want to do some cleaning after the recomposition
 */
@Composable
fun DisposableEffect() {

    val lifecycleOwner = LocalLifecycleOwner.current

    androidx.compose.runtime.DisposableEffect(key1 = true) {
        val lifeCyleObserver = LifecycleEventObserver { _, event ->
            if (event == Lifecycle.Event.ON_PAUSE){
                println("Lifecycle event is onPause")
            }
        }
        lifecycleOwner.lifecycle.addObserver(lifeCyleObserver)

        onDispose {
            lifecycleOwner.lifecycle.removeObserver(lifeCyleObserver)
        }
    }

}