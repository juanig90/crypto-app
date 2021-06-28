package com.example.cryptoapp.data.local

import com.example.cryptoapp.data.LocalDataSource
import com.example.cryptoapp.data.entity.LocalCoin
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(private val dao: CoinDao): LocalDataSource {

    override suspend fun getCoins(): Flow<List<LocalCoin>> {
        return dao.getAll()
    }

    override suspend fun saveCoins(vararg coins: LocalCoin) {
        return dao.insertAll(*coins)
    }

    override suspend fun deleteCoin(coin: LocalCoin) {
        return dao.delete(coin)
    }
}