package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.OptionItemUI

interface SaveFavoriteUseCase {

    suspend operator fun invoke(item: OptionItemUI)

}