package com.example.cryptoapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase

import javax.inject.Inject

private const val TAG = "HomeViewModel"

class HomeViewModel @Inject constructor(private val coinsUseCase: CoinsUseCase) : ViewModel() {

    val liveFavorites: LiveData<List<FavoriteItemUI>>
        get() = mutableLiveFavorites

    val liveCoinSelected: LiveData<String>
        get() = mutableLiveCoinSelected

    val liveLoading: LiveData<Boolean>
        get() = mutableLiveLoading

    val liveError: LiveData<String>
        get() = mutableLiveError

    private val mutableLiveFavorites = MutableLiveData<List<FavoriteItemUI>>()

    private val mutableLiveCoinSelected = MutableLiveData<String>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = MutableLiveData<String>()

    fun onLoadFavorites() {}

    fun onCoinSelected(id: String) {
        mutableLiveCoinSelected.value = id
    }

}