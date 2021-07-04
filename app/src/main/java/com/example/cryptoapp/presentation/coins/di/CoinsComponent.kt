package com.example.cryptoapp.presentation.coins.di

import com.example.cryptoapp.di.ActivityScope
import com.example.cryptoapp.presentation.coins.ChooseFavoritesActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [CoinViewModelModule::class])
interface CoinsComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): CoinsComponent
    }

    fun inject(activity: ChooseFavoritesActivity)
}