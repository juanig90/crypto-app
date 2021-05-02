package com.example.cryptoapp.data.local

import com.example.cryptoapp.data.LocalDataSource
import com.example.cryptoapp.data.entity.LocalCoin
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: CoinDao): LocalDataSource {

    override fun getCoins(): Single<List<LocalCoin>> {
        return dao.getAll()
    }

    override fun saveCoins(vararg coins: LocalCoin): Completable {
        return dao.insertAll(*coins)
    }

    override fun deleteCoin(coin: LocalCoin): Completable {
        return dao.delete(coin)
    }
}