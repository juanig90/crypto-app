package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import javax.inject.Inject

class SelectionCoinUseCaseImpl @Inject constructor(
    private val repository: CoinsRepository
) : SelectionCoinUseCase {

    override suspend operator fun invoke(): Result<List<OptionItemUI>> {
        return repository.getOptionItems()
    }
}