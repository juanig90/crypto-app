package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.ErrorMapper
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.entity.CoinDetail
import com.example.cryptoapp.domain.repository.CoinsRepository
import kotlinx.coroutines.flow.Flow

import javax.inject.Inject

class CoinsUseCaseImpl @Inject constructor(
    private val repository: CoinsRepository,
    private val errorMapper: ErrorMapper
    ) : CoinsUseCase {

    override fun getCoins(local: Boolean): Flow<Result<List<Coin>>> {
        return repository.getCoins(local)
    }

    override fun getCoinDetail(id: String): Flow<Result<CoinDetail>> {
        return repository.getCoinDetail(id)
    }

    override suspend fun saveCoin(coin: Coin) {
        return repository.saveCoin(coin)
    }

    override suspend fun deleteCoin(coin: Coin) {
        return repository.deleteCoin(coin)
    }
}