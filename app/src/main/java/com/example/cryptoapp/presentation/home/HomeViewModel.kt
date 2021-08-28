package com.example.cryptoapp.presentation.home

import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import com.example.cryptoapp.presentation.BaseViewModel
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val coinsUseCase: CoinsUseCase)
    : BaseViewModel<List<FavoriteItemUI>>() {

    fun onLoadFavorites() {
        doWork {
            coinsUseCase.getFavoriteItems()
        }
    }

}