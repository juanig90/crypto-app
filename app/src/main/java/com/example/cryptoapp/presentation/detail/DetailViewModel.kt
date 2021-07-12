package com.example.cryptoapp.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val useCase: CoinsUseCase): ViewModel() {

    private val mutableLiveData = MutableLiveData<DetailUI>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = MutableLiveData<String>()

    val liveDataError: LiveData<String> = mutableLiveError

    val liveData: LiveData<DetailUI> = mutableLiveData

    val liveLoadingData = mutableLiveLoading

    fun getDetail(id: String) {}

}