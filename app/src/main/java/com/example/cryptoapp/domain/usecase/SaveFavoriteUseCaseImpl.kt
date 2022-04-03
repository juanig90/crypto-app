package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository
import javax.inject.Inject

class SaveFavoriteUseCaseImpl @Inject constructor(
    private val repository: CoinsRepository
) : SaveFavoriteUseCase {

    override suspend operator fun invoke(item: Coin) {
        return repository.saveFavorite(item)
    }
}