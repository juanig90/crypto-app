package com.example.cryptoapp.data

import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository

class CoinsRepositoryImpl(private val remoteData: CoinsDataSource): CoinsRepository {

    override fun getCoins(): List<Coin> = remoteData.getCoins()
}