package com.example.cryptoapp.data.local

import com.example.cryptoapp.data.CoinsLocalDataSource
import com.example.cryptoapp.data.entity.CoinLocal
import io.reactivex.rxjava3.core.Single

class CoinsLocalDataImpl(private val dao: CoinDao): CoinsLocalDataSource {

    override fun getCoins(): Single<List<CoinLocal>> {
        return dao.getAll()
    }

    override fun saveCoins(coins: List<CoinLocal>) {
        dao.insertAll(coins)
    }
}