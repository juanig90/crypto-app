package com.example.cryptoapp.data.local

import com.example.cryptoapp.data.LocalDataSource
import com.example.cryptoapp.data.entity.CoinLocal
import io.reactivex.rxjava3.core.Single

class LocalDataSourceImpl(private val dao: CoinDao): LocalDataSource {

    override fun getCoins(): Single<List<CoinLocal>> {
        return dao.getAll()
    }

    override fun saveCoins(coins: List<CoinLocal>) {
        dao.insertAll(coins)
    }
}