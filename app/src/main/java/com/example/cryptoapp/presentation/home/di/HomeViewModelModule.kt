package com.example.cryptoapp.presentation.home.di

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.di.ViewModelKey
import com.example.cryptoapp.presentation.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class HomeViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindViewModel(viewModel: HomeViewModel): ViewModel
}