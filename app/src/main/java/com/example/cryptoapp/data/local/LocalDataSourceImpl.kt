package com.example.cryptoapp.data.local

import com.example.cryptoapp.data.LocalDataSource
import com.example.cryptoapp.data.entity.LocalCoin
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: CoinDao): LocalDataSource {

    override fun getCoins(): Single<List<LocalCoin>> {
        return dao.getAll()
    }

    override fun saveCoins(coins: List<LocalCoin>) {
        dao.insertAll(coins)
    }
}