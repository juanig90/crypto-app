package com.example.cryptoapp.presentation.detail.di

import com.example.cryptoapp.di.ActivityScope
import com.example.cryptoapp.presentation.detail.DetailActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [DetailViewModelModule::class])
interface DetailComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): DetailComponent
    }

    fun inject(activity: DetailActivity)

}