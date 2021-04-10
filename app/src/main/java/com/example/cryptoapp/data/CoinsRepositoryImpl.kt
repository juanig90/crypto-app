package com.example.cryptoapp.data

import com.example.cryptoapp.data.entity.CoinApiResponse
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository

class CoinsRepositoryImpl(
    private val remoteData: CoinsDataSource,
    private val mapper: Mapper<Coin, CoinApiResponse>
    ): CoinsRepository {

    override fun getCoins(): List<Coin> {
        return remoteData.getCoins().map {
            mapper.fromEntityToDomainModel(it)
        }
    }
}