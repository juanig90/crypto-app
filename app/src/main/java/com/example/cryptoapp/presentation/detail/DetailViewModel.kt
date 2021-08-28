package com.example.cryptoapp.presentation.detail

import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import com.example.cryptoapp.presentation.BaseViewModel
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val useCase: CoinsUseCase): BaseViewModel<DetailUI>() {

    fun getDetail(id: String) {
        doWork {
            useCase.getDetail(id)
        }
    }

}