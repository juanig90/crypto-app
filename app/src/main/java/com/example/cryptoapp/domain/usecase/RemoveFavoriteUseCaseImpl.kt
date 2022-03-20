package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import javax.inject.Inject

class RemoveFavoriteUseCaseImpl @Inject constructor(
    private val repository: CoinsRepository
) : RemoveFavoriteUseCase {

    override suspend operator fun invoke(item: OptionItemUI) {
       return repository.removeFavorite(item)
    }
}