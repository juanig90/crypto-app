package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import javax.inject.Inject

class FavoriteCoinUseCaseImpl @Inject constructor(
    private val repository: CoinsRepository
): FavoriteCoinUseCase {

    override suspend operator fun invoke(): Result<List<FavoriteItemUI>> {
        return repository.getFavoriteItems()
    }
}