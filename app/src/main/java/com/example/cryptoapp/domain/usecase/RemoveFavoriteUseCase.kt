package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.Coin

interface RemoveFavoriteUseCase {

    suspend operator fun invoke(item: Coin)

}