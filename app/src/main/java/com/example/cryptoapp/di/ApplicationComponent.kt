package com.example.cryptoapp.di

import com.example.cryptoapp.CoinViewModelModule
import com.example.cryptoapp.CoinsActivity
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