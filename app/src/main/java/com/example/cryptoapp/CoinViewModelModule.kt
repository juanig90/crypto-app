package com.example.cryptoapp

import androidx.lifecycle.ViewModel
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