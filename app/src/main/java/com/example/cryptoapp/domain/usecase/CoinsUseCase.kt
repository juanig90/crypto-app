package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CoinsUseCase {

    fun getCoins(local: Boolean = false): Single<Result<List<Coin>>>
    fun getCoinDetail(id: String): Single<Result<CoinDetail>>
    fun saveCoin(coin: Coin): Completable
    fun deleteCoin(coin: Coin): Completable
}