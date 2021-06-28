package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail

interface CoinsUseCase {

    fun getCoins(local: Boolean = false): Result<List<Coin>>
    fun getCoinDetail(id: String): Result<CoinDetail>
    fun saveCoin(coin: Coin)
    fun deleteCoin(coin: Coin)
}