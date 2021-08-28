package com.example.cryptoapp.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel<T >: ViewModel() {

    private val mutableLiveData = MutableLiveData<T>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = MutableLiveData<String>()

    protected val liveData: LiveData<T>
        get() = mutableLiveData

    protected val liveLoading: LiveData<Boolean>
        get() = mutableLiveLoading

    protected val liveError: LiveData<String>
        get() = mutableLiveError

}