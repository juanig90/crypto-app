package com.example.cryptoapp.presentation.home

import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.usecase.FavoriteCoinUseCase
import com.example.cryptoapp.presentation.BaseViewModel
import javax.inject.Inject


class HomeViewModel @Inject constructor(private val favoriteUseCase: FavoriteCoinUseCase)
    : BaseViewModel<List<FavoriteItemUI>>() {

    fun onLoadFavorites() {
        doWork {
            favoriteUseCase()
        }
    }

}