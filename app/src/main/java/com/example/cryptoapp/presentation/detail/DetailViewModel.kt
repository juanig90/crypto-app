package com.example.cryptoapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val useCase: CoinsUseCase): ViewModel() {

    private val mutableLiveData = MutableLiveData<DetailUI>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = MutableLiveData<String>()

    val liveDataError: LiveData<String> = mutableLiveError

    val liveData: LiveData<DetailUI> = mutableLiveData

    val liveLoadingData = mutableLiveLoading

    fun getDetail(id: String) {
        viewModelScope.launch {
            useCase.getDetail(id)
                .onStart { mutableLiveLoading.value = true }
                .collect { result ->
                    mutableLiveLoading.value = false
                    when (result) {
                        is Result.Success -> mutableLiveData.value = result.data
                        is Result.Error -> mutableLiveError.value = result.msg
                    }
                }
        }

    }

}