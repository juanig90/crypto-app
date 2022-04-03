package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.core.resource.Result
import com.example.cryptoapp.domain.entity.DetailUI

interface CoinDetailUseCase {

    suspend operator fun invoke(id: String): Result<DetailUI>
}