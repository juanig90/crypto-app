package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.domain.entity.Coin
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CoinsRepository {

    fun getCoins(local: Boolean = false): Single<List<Coin>>
    fun saveCoin(coin: Coin): Completable
    fun deleteCoin(coin: Coin): Completable
}