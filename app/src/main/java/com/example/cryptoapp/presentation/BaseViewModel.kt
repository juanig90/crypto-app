package com.example.cryptoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.domain.core.resource.Result
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

open class BaseViewModel<T>: ViewModel() {

    private val mutableStateData = MutableStateFlow<Result<T>>(Result.Loading(false))

    private val mutableSharedEvent = MutableSharedFlow<UIEvent>()

    val stateData: StateFlow<Result<T>>
        get() = mutableStateData

    val sharedEvent: SharedFlow<UIEvent>
        get() = mutableSharedEvent

    protected fun doWork(block: suspend() -> Result<T>) {
        viewModelScope.launch {
            mutableStateData.value = Result.Loading(true)
            val result = block()
            mutableStateData.value = Result.Loading(false)
            when (result) {
                is Result.Success -> mutableStateData.value = result
                is Result.Error -> {
                    mutableStateData.value = result
                    mutableSharedEvent.emit(UIEvent.SnackBarEvent(result.msg))
                }
            }
        }
    }

    sealed class UIEvent(val msg: String) {
        class SnackBarEvent(msg: String): UIEvent(msg)
        class ToastEvent(msg: String): UIEvent(msg)
    }

}