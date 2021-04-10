package com.example.cryptoapp.di

import com.example.cryptoapp.ViewModelBuilderModule
import com.example.cryptoapp.presentation.coins.di.CoinsComponent
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        Networking::class,
        Subcomponents::class,
        ViewModelBuilderModule::class,
    ]
)
interface ApplicationComponent {

  fun coinsComponent(): CoinsComponent.Factory
}

@Module(subcomponents = [CoinsComponent::class])
object Subcomponents