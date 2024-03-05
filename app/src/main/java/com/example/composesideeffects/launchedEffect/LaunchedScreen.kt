package com.example.composesideeffects.launchedEffect

import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember

/**
 * This is an example of how to use Launched Effect
 * We can use Key as Unit or True so the launched effect gets to the composition everytime the LaunchedScreen is composed
 * Used cases include, triggering a
 */
@Composable
fun LaunchedScreen(
    viewModel: LaunchedEffectViewModel
) {

    LaunchedEffect(key1 = Unit) {
        viewModel.state.collect {
            when(it){
                is StateObserver.Showsnackbar -> TODO()

                is StateObserver.Error -> TODO()
            }
        }
    }
}

@Composable
fun AnotherLaunchedEffect(
    counter:Int
) {
    val animatable = remember {
        Animatable(0f)
    }
    LaunchedEffect(key1 =counter) {
        animatable.animateTo(counter.toFloat())
    }
}