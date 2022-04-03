package com.example.cryptoapp.presentation.home

import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.usecase.FavoriteCoinUseCase
import com.example.cryptoapp.presentation.BaseViewModel
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val favoriteUseCase: FavoriteCoinUseCase)
    : BaseViewModel<List<Coin>>() {

    fun onLoadFavorites() {
        doWork {
            favoriteUseCase()
        }
    }

}