package com.example.cryptoapp.presentation.detail

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val useCase: CoinsUseCase): ViewModel() {

    private val compositeDisposable = CompositeDisposable()

    private val mutableLiveData = MutableLiveData<DetailUI>()

    private val mutableLiveLoading = MutableLiveData<Boolean>()

    private val mutableLiveError = MutableLiveData<String>()

    val liveDataError: LiveData<String> = mutableLiveError

    val liveData: LiveData<DetailUI> = mutableLiveData

    val liveLoadingData = mutableLiveLoading

    fun getDetail(id: String) {
        useCase.getDetail(id)
            .doOnSubscribe {
                mutableLiveLoading.value = true
            }
            .doOnTerminate {
                mutableLiveLoading.value = false
            }
            .subscribe({ result ->
                Log.d("DetailViewModel", "onResult: $result")
                when (result) {
                    is Result.Success -> mutableLiveData.value = result.data
                    is Result.Error -> mutableLiveError.value = result.msg

                }
        },{
            Log.e("DetailViewModel", "onError:${it.message}")
        }).addTo(compositeDisposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }

}