package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.OptionItemUI

interface RemoveFavoriteUseCase {

    suspend operator fun invoke(item: OptionItemUI)

}