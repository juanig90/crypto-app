package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.LocalCoin
import com.example.cryptoapp.data.entity.RemoteCoinDetail
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail
import com.example.cryptoapp.domain.repository.CoinsRepository

class CoinsRepositoryImpl(
    private val localData: LocalDataSource,
    private val remoteData: RemoteDataSource): CoinsRepository {

    override fun getCoins(local: Boolean): Result<List<Coin>> {
        return if(local) getLocalCoins() else getAllCoins()
    }

    override fun getCoinDetail(id: String): Result<CoinDetail> {
        TODO("Not yet implemented")
    }

    private fun hasData(coin: RemoteCoinDetail): Boolean {
        return coin.marketData.percentageChange24h.eur  != null ||
               coin.marketData.percentageChange7d.eur   != null ||
               coin.marketData.percentageChange30d.eur  != null
    }

    private fun getAllCoins(): Result<List<Coin>> {
        TODO("Not yet implemented")
    }

    private fun getRemoteCoins(): Result<List<Coin>> {
        TODO("Not yet implemented")
    }

    private fun getLocalCoins(): Result<List<Coin>> {
        TODO("Not yet implemented")
    }

    override fun saveCoin(coin: Coin) {
        TODO("Not yet implemented")
    }

    override fun deleteCoin(coin: Coin) {
        TODO("Not yet implemented")
    }
}