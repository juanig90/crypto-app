package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.core.resource.Result
import com.example.cryptoapp.domain.entity.Coin

interface SelectionCoinUseCase {

    suspend operator fun  invoke(): Result<List<Coin>>

}