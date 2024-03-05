package com.example.composesideeffects.derivedstateof

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

/**
 * DerivedStateOf will cache the value and every dependency that needs the value will not need to be
 */
@Composable
fun DerivedStateOf() {
    var counter by remember {
        mutableIntStateOf(0)
    }

    val counterText by remember {
        derivedStateOf {  "Updated counter $counter"}
    }
    Button(onClick = { counter ++ }) {
        Text(text = counterText)
    }
}