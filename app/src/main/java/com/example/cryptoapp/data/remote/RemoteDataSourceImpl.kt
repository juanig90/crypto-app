package com.example.cryptoapp.data.remote

import com.example.cryptoapp.data.RemoteDataSource
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteDataSourceImpl @Inject constructor(private val client: CoinAPI): RemoteDataSource {

    override suspend fun getCoins() = flow { emit(client.getCoinsList()) }
    override suspend fun getDetailCoin(id: String) = flow { emit(client.getCoinDetail(id))  }
    override suspend fun getHistoricalPrices(id: String) = flow { emit(client.getHistoricalCoin(id)) }
}