package com.example.cryptoapp.di

import com.example.cryptoapp.presentation.coins.di.CoinViewModelModule
import com.example.cryptoapp.presentation.coins.CoinsActivity
import com.example.cryptoapp.ViewModelBuilderModule
import dagger.Component

@Component(
    modules = [
        ViewModelBuilderModule::class,
        CoinViewModelModule::class
    ]
)
interface ApplicationComponent {


    fun inject(activity: CoinsActivity)

}