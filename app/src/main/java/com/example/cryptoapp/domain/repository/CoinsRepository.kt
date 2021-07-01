package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail
import kotlinx.coroutines.flow.Flow


interface CoinsRepository {

    suspend fun getCoins(local: Boolean = false): Flow<Result<List<Coin>>>
    suspend fun getCoinDetail(id: String): Flow<Result<CoinDetail>>
    suspend fun saveCoin(coin: Coin)
    suspend fun deleteCoin(coin: Coin)
}