package com.example.cryptoapp.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import kotlinx.coroutines.launch
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

    fun onLoadFavorites() {
        viewModelScope.launch {
            mutableLiveLoading.value = true
            val result = coinsUseCase.getFavoriteItems()
            mutableLiveLoading.value = false
            when(result) {
                is Result.Success -> mutableLiveFavorites.value = result.data
                is Result.Error -> mutableLiveError.value = result.msg
            }
        }
    }

    fun onCoinSelected(id: String) {
        mutableLiveCoinSelected.value = id
    }

}