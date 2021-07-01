package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.RemoteCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.data.entity.RemoteHistoricalPrices
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {

    suspend fun getCoins(): Flow<List<RemoteCoin>>
    suspend fun getDetailCoin(id: String): Flow<RemoteCoinDetail>
    suspend fun getHistoricalPrices(id: String): Flow<RemoteHistoricalPrices>
}