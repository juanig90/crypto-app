package com.example.cryptoapp.presentation.detail

import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.usecase.CoinDetailUseCase
import com.example.cryptoapp.domain.usecase.FavoriteCoinUseCase
import com.example.cryptoapp.presentation.BaseViewModel
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val detailCoinUseCase: CoinDetailUseCase
): BaseViewModel<DetailUI>() {

    fun getDetail(id: String) {
        doWork {
            detailCoinUseCase(id)
        }
    }

}