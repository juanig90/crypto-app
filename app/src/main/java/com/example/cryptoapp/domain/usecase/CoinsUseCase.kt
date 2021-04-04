package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.Coin

interface CoinsUseCase {

    fun getCoins(): List<Coin>
}