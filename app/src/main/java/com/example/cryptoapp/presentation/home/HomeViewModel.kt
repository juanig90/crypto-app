package com.example.cryptoapp.presentation.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

private const val TAG = "HomeViewModel"

class HomeViewModel @Inject constructor(private val coinsUseCase: CoinsUseCase) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()

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

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

    fun onLoadFavorites() {
        coinsUseCase.getFavoriteItems()
            .doOnSubscribe { mutableLiveLoading.value = true }
            .doOnTerminate { mutableLiveLoading.value = false }
            .subscribe({ result ->
                when(result) {
                    is Result.Success -> mutableLiveFavorites.value = result.data
                    is Result.Error -> mutableLiveError.value = result.msg
                }
            }, {
                Log.e(TAG, "onLoadFavorites:onError ${it.localizedMessage}")
            }).addTo(compositeDisposable)
    }

    fun onCoinSelected(id: String) {
        mutableLiveCoinSelected.value = id
    }

}