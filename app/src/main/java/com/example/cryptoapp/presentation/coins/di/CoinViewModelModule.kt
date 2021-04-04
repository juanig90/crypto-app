package com.example.cryptoapp.presentation.coins.di

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.presentation.coins.CoinsViewModel
import com.example.cryptoapp.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class CoinViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(CoinsViewModel::class)
    abstract fun bindViewModel(viewModel: CoinsViewModel): ViewModel
}