package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.domain.entity.Coin
import io.reactivex.rxjava3.core.Single

interface CoinsRepository {

    fun getCoins(): Single<List<Coin>>
}