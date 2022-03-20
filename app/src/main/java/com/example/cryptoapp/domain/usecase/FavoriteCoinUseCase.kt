package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.FavoriteItemUI

interface FavoriteCoinUseCase {

    suspend operator fun invoke(): Result<List<FavoriteItemUI>>

}