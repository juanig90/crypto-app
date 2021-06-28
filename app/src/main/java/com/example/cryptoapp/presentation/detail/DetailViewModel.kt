package com.example.cryptoapp.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.CoinDetail
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val useCase: CoinsUseCase): ViewModel() {

    private val mutableLiveData = MutableLiveData<CoinDetail>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = MutableLiveData<String>()

    val liveDataError: LiveData<String> = mutableLiveError

    val liveData: LiveData<CoinDetail> = mutableLiveData

    val liveLoadingData = mutableLiveLoading

    fun getDetail(id: String) {
        TODO("Not yet implemented")
    }

}