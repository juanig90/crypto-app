package com.example.cryptoapp.presentation.detail.di

import androidx.lifecycle.ViewModel
import com.example.cryptoapp.di.ViewModelKey
import com.example.cryptoapp.presentation.detail.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class DetailViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailViewModel::class)
    abstract fun bindViewModel(viewModel: DetailViewModel): ViewModel

}