package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository
import javax.inject.Inject

class CoinsUseCaseImpl @Inject constructor(
        private val repository: CoinsRepository
) : CoinsUseCase {

    override fun getCoins(): List<Coin> {
        return repository.getCoins()
    }
}