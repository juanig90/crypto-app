package com.example.cryptoapp.presentation.coins

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import javax.inject.Inject

private const val TAG = "CoinsViewModel"

class CoinsViewModel @Inject constructor(private val coinsUseCase: CoinsUseCase) : ViewModel()