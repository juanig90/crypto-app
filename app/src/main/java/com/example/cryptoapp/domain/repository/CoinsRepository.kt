package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail


interface CoinsRepository {

    fun getCoins(local: Boolean = false): Result<List<Coin>>
    fun saveCoin(coin: Coin)
    fun deleteCoin(coin: Coin)
    fun getCoinDetail(id: String): Result<CoinDetail>
}