package com.example.cryptoapp

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