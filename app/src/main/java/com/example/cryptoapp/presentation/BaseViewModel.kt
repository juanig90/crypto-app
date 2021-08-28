package com.example.cryptoapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.Result
import kotlinx.coroutines.launch

open class BaseViewModel<T>: ViewModel() {

    private val mutableLiveData = MutableLiveData<T>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = MutableLiveData<String>()

    val liveData: LiveData<T>
        get() = mutableLiveData

    val liveLoading: LiveData<Boolean>
        get() = mutableLiveLoading

    val liveError: LiveData<String>
        get() = mutableLiveError

    protected fun doWork(block: suspend() -> Result<T> ) {
        viewModelScope.launch {
            mutableLiveLoading.value = true
            val result = block()
            mutableLiveLoading.value = false
            when (result) {
                is Result.Success -> mutableLiveData.value = result.data
                is Result.Error -> mutableLiveError.value = result.msg
            }
        }
    }

}