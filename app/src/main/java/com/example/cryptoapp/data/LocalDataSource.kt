package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface LocalDataSource {

    fun getCoins(): Single<List<LocalCoin>>
    fun saveCoins(vararg coins: LocalCoin): Completable
    fun deleteCoin(coin: LocalCoin): Completable
}