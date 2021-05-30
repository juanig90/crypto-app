package com.example.cryptoapp.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.domain.entity.CoinDetail
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val useCase: CoinsUseCase): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val mutableLiveData = MutableLiveData<CoinDetail>()

    val liveData: LiveData<CoinDetail> = mutableLiveData

    fun getDetail(id: String) {
        useCase.getCoinDetail(id).subscribe({ detail ->
            Log.d("DetailViewModel", "getDetail: $detail")
            mutableLiveData.value = detail
        },{
            Log.e("DetailViewModel", "onError:${it.message}")
        }).addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}