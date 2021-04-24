package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.CoinLocal
import io.reactivex.rxjava3.core.Single

interface CoinsLocalDataSource {

    fun getCoins(): Single<List<CoinLocal>>
    fun saveCoins(coins: List<CoinLocal>)

}