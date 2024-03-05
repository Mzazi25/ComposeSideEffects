package com.example.composesideeffects.launchedEffect

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import java.util.Objects

class LaunchedEffectViewModel(

):ViewModel() {
    private val _state = MutableSharedFlow<StateObserver> ()
    val state:SharedFlow<StateObserver> = _state.asSharedFlow()

    init {
        viewModelScope.launch {
            _state.emit(StateObserver.Showsnackbar("Hello World"))
        }
    }

}

sealed interface StateObserver {
    data class Showsnackbar(val message:String):StateObserver
    data class Error(val throwable:Throwable):StateObserver
}
