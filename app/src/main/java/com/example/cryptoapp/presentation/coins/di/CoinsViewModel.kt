package com.example.cryptoapp.presentation.coins.di

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

private const val TAG = "CoinsViewModel"

class CoinsViewModel @Inject constructor(private val coinsUseCase: CoinsUseCase) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    val liveCoins: LiveData<List<OptionItemUI>>
        get() = mutableLiveCoins

    val liveLoading: LiveData<Boolean>
        get() = mutableLiveLoading

    val liveError: LiveData<String>
        get() = mutableLiveError

    private val mutableLiveCoins = MutableLiveData<List<OptionItemUI>>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = MutableLiveData<String>()

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun onLoadCoins() {
        coinsUseCase.getOptionItems()
            .doOnSubscribe { mutableLiveLoading.value = true }
            .doOnTerminate { mutableLiveLoading.value = false }
            .subscribe({ result ->
                Log.d(TAG, "onLoadCoins:onResult $result")
                when(result) {
                    is Result.Success -> mutableLiveCoins.value = result.data
                    is Result.Error -> mutableLiveError.value = result.msg
                }
            }, {
                Log.e(TAG, "onLoadCoins:onError ${it.localizedMessage}")
            }).addTo(compositeDisposable)
    }

    fun onSwitchChanged(item: OptionItemUI, value: Boolean) {
        if (value)
            coinsUseCase.saveFavorite(item).subscribe({
                Log.d(TAG, "onSwitchChanged save successfully")
            }, {
                Log.e(TAG, "onSwitchChanged save error ${it.localizedMessage}")
            }).addTo(compositeDisposable)
        else
            coinsUseCase.removeFavorite(item).subscribe({
                Log.d(TAG, "onSwitchChanged delete successfully")
            }, {
                Log.e(TAG, "onSwitchChanged delete error ${it.localizedMessage}")
            }).addTo(compositeDisposable)
    }

}