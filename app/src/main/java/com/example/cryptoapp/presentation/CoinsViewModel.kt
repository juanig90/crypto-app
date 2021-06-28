package com.example.cryptoapp.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import com.example.cryptoapp.presentation.CoinsViewModel.CoinUI.*
import javax.inject.Inject

private const val TAG = "CoinsViewModel"

class CoinsViewModel @Inject constructor(private val coinsUseCase: CoinsUseCase) : ViewModel() {

    val liveCoins: LiveData<CoinUI>
        get() = mutableLiveCoins

    val liveCoin: LiveData<Coin>
        get() = mutableLiveCoin

    val liveLoading: LiveData<Boolean>
        get() = mutableLiveLoading

    val liveError: LiveData<String>
        get() = mutableLiveError

    private val mutableLiveCoins = MutableLiveData<CoinUI>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = MutableLiveData<String>()

    private val mutableLiveCoin = MutableLiveData<Coin>()

    fun onLoadCoins(local: Boolean = false) {
        TODO("Not yet implemented")
    }

    fun onSwitchChanged(coin: Coin, value: Boolean) {
        TODO("Not yet implemented")
    }

    fun onCoinSelected(coin: Coin) {
        mutableLiveCoin.value = coin
    }

    sealed class CoinUI(val coins: List<Coin>) {

        class CardUI(coins: List<Coin>) : CoinUI(coins)
        class SwitchUI(coins: List<Coin>) : CoinUI(coins)
    }

}