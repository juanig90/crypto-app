package com.example.cryptoapp.presentation.home.di

import com.example.cryptoapp.presentation.coins.di.CoinViewModelModule
import com.example.cryptoapp.presentation.home.HomeActivity
import dagger.Subcomponent

@Subcomponent(modules = [CoinViewModelModule::class])
abstract class HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    abstract fun inject(activity: HomeActivity)

}