package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail
import com.example.cryptoapp.domain.repository.CoinsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map

class CoinsRepositoryImpl(
    private val localData: LocalDataSource,
    private val remoteData: RemoteDataSource): CoinsRepository {

    override suspend fun getCoins(local: Boolean): Flow<Result<List<Coin>>> {
        return getRemoteCoins().flowOn(Dispatchers.IO)
    }

    override suspend fun getCoinDetail(id: String): Flow<Result<CoinDetail>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveCoin(coin: Coin) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCoin(coin: Coin) {
        TODO("Not yet implemented")
    }

    private fun hasData(coin: RemoteCoinDetail): Boolean {
        return coin.marketData.percentageChange24h.eur  != null ||
               coin.marketData.percentageChange7d.eur   != null ||
               coin.marketData.percentageChange30d.eur  != null
    }

    private fun getAllCoins(): Flow<Result<List<Coin>>> {
        TODO("Not yet implemented")
    }

    private suspend fun getRemoteCoins(): Flow<Result<List<Coin>>> {
        return remoteData.getCoins().map { coins ->
            Result.Success(coins.map { coin ->
                Coin(
                    id = coin.id,
                    symbol = coin.symbol,
                    name = coin.name
                )
            })
        }
    }

    private fun getLocalCoins(): Flow<Result<List<Coin>>> {
        TODO("Not yet implemented")
    }

}