package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.core.resource.Result
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import javax.inject.Inject

class CoinDetailUseCaseImpl @Inject constructor(
    private val repository: CoinsRepository
) : CoinDetailUseCase {


    override suspend operator fun invoke(id: String): Result<DetailUI> {
        return repository.getDetail(id)
    }
}