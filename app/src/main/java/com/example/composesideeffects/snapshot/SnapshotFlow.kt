package com.example.composesideeffects.snapshot

import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.snapshotFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.mapNotNull

/**
 * used when we want to create a flow since Snapshot returns a Flow<T>
 * This is a basic example
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SnapshotFlow() {
    val scaffoldState = rememberBottomSheetScaffoldState()
    LaunchedEffect(key1 = scaffoldState) {
        snapshotFlow { scaffoldState.snackbarHostState}
            .mapNotNull {
                it.currentSnackbarData?.visuals?.message
            }
            .distinctUntilChanged()
            .collect {
                println("Message was shown $it")
            }
    }
}