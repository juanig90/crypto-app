package com.example.cryptoapp.presentation.coins

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import javax.inject.Inject

private const val TAG = "CoinsViewModel"

class CoinsViewModel @Inject constructor(private val coinsUseCase: CoinsUseCase) : ViewModel() {

    val liveCoins: LiveData<List<Coin>>
    get() = mutableLiveCoins

    private val mutableLiveCoins = MutableLiveData<List<Coin>>()

    fun onLoadCoins() {
         coinsUseCase.getCoins().subscribe({ coins ->
             Log.d(TAG, "onLoadCoins:onSuccessSubscribe $coins")
             mutableLiveCoins.value = coins
         }, {
             Log.d(TAG, "onLoadCoins:onErrorSubscribe ${it.localizedMessage}")
         })
    }

}