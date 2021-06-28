package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail
import com.example.cryptoapp.domain.repository.CoinsRepository
import kotlinx.coroutines.flow.Flow

class CoinsRepositoryImpl(
    private val localData: LocalDataSource,
    private val remoteData: RemoteDataSource): CoinsRepository {

    override fun getCoins(local: Boolean): Flow<Result<List<Coin>>> {
        TODO("Not yet implemented")
    }

    override fun getCoinDetail(id: String): Flow<Result<CoinDetail>> {
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

    private fun getRemoteCoins(): Flow<Result<List<Coin>>> {
        TODO("Not yet implemented")
    }

    private fun getLocalCoins(): Flow<Result<List<Coin>>> {
        TODO("Not yet implemented")
    }

}