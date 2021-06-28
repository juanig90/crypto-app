package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail
import kotlinx.coroutines.flow.Flow

interface CoinsUseCase {

    fun getCoins(local: Boolean = false): Flow<Result<List<Coin>>>
    fun getCoinDetail(id: String): Flow<Result<CoinDetail>>
    suspend fun saveCoin(coin: Coin)
    suspend fun deleteCoin(coin: Coin)
}