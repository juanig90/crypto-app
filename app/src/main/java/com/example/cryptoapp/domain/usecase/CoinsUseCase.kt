package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.Coin
import io.reactivex.rxjava3.core.Single

interface CoinsUseCase {

    fun getCoins(): Single<List<Coin>>
}