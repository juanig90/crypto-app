package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.ErrorMapper
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail
import com.example.cryptoapp.domain.repository.CoinsRepository

import javax.inject.Inject

class CoinsUseCaseImpl @Inject constructor(
    private val repository: CoinsRepository,
    private val errorMapper: ErrorMapper
    ) : CoinsUseCase {

    override fun getCoins(local: Boolean): Result<List<Coin>> {
        return repository.getCoins(local)
    }

    override fun getCoinDetail(id: String): Result<CoinDetail> {
        return repository.getCoinDetail(id)
    }

    override fun saveCoin(coin: Coin) {
        return repository.saveCoin(coin)
    }

    override fun deleteCoin(coin: Coin) {
        return repository.deleteCoin(coin)
    }
}