package com.example.cryptoapp.presentation.detail

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.domain.usecase.CoinsUseCase
import javax.inject.Inject

class DetailViewModel @Inject constructor(private val useCase: CoinsUseCase): ViewModel() {
}