package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.core.resource.Result
import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository
import javax.inject.Inject

class SelectionCoinUseCaseImpl @Inject constructor(
    private val repository: CoinsRepository
) : SelectionCoinUseCase {

    override suspend operator fun invoke(): Result<List<Coin>> {
        return repository.getCoins()
    }
}