package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import javax.inject.Inject

class SaveFavoriteUseCaseImpl @Inject constructor(
    private val repository: CoinsRepository
) : SaveFavoriteUseCase {

    override suspend operator fun invoke(item: OptionItemUI) {
        return repository.saveFavorite(item)
    }
}