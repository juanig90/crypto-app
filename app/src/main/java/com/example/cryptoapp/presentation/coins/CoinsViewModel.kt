package com.example.cryptoapp.presentation.coins

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "CoinsViewModel"

class CoinsViewModel @Inject constructor(private val coinsUseCase: CoinsUseCase) : ViewModel() {

    val liveCoins: LiveData<List<OptionItemUI>>
        get() = mutableLiveCoins

    val liveLoading: LiveData<Boolean>
        get() = mutableLiveLoading

    val liveError: LiveData<String>
        get() = mutableLiveError

    private val mutableLiveCoins = MutableLiveData<List<OptionItemUI>>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = MutableLiveData<String>()

    fun onLoadCoins() {
        viewModelScope.launch {
            mutableLiveLoading.value = true
            val result = coinsUseCase.getOptionItems()
            mutableLiveLoading.value = false
            when (result) {
                is Result.Success -> mutableLiveCoins.value = result.data
                is Result.Error -> mutableLiveError.value = result.msg
            }
        }
    }

    fun onSwitchChanged(item: OptionItemUI, value: Boolean) {
        Log.d(TAG, "onSwitchChanged ${item.symbol} $value")
        viewModelScope.launch {
               if (value)
                   coinsUseCase.saveFavorite(item)
               else
                   coinsUseCase.removeFavorite(item)
           }
    }

}