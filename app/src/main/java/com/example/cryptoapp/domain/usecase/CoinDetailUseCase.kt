package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.DetailUI

interface CoinDetailUseCase {

    suspend operator fun invoke(id: String): Result<DetailUI>
}