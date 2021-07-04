package com.example.cryptoapp.presentation.home.di

import com.example.cryptoapp.di.ActivityScope
import com.example.cryptoapp.presentation.home.HomeActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [HomeViewModelModule::class])
abstract class HomeComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): HomeComponent
    }

    abstract fun inject(activity: HomeActivity)

}