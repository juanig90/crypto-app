package com.example.cryptoapp.presentation.coins

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.presentation.SingleLiveEvent
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import javax.inject.Inject

private const val TAG = "CoinsViewModel"

class CoinsViewModel @Inject constructor(private val coinsUseCase: CoinsUseCase) : ViewModel() {

    val liveCoins: LiveData<List<Coin>>
        get() = mutableLiveCoins

    val liveLoading: LiveData<Boolean>
        get() = mutableLiveLoading

    val liveError: LiveData<Nothing>
        get() = mutableLiveError

    private val mutableLiveCoins = MutableLiveData<List<Coin>>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = SingleLiveEvent<Nothing>()

    fun onLoadCoins() {
        coinsUseCase.getCoins()
            .doOnSubscribe { mutableLiveLoading.value = true }
            .doOnTerminate { mutableLiveLoading.value = false }
            .subscribe({ coins ->
                Log.d(TAG, "onLoadCoins:onSuccessSubscribe $coins")
                mutableLiveCoins.value = coins
            }, {
                Log.d(TAG, "onLoadCoins:onErrorSubscribe ${it.localizedMessage}")
                mutableLiveError.call()
            })
    }

    fun onSwitchChanged(coin: Coin, value: Boolean) {
        if (value)
            coinsUseCase.saveCoin(coin).subscribe({
                Log.d(TAG, "onSwitchChanged save successfully")
            }, {
                Log.d(TAG, "onSwitchChanged save error ${it.localizedMessage}")
            })
        else
            coinsUseCase.deleteCoin(coin).subscribe({
                Log.d(TAG, "onSwitchChanged delete successfully")
            }, {
                Log.d(TAG, "onSwitchChanged delete error ${it.localizedMessage}")
            })
    }

}