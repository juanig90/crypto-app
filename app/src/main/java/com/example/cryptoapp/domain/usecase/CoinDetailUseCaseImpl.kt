package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
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