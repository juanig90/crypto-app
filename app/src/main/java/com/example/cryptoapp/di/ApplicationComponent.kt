package com.example.cryptoapp.di

import android.content.Context
import com.example.cryptoapp.presentation.coins.di.CoinsComponent
import com.example.cryptoapp.presentation.home.di.HomeComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkingModule::class,
        Subcomponents::class,
        ViewModelBuilderModule::class,
    ]
)
interface ApplicationComponent {

  fun coinsComponent(): CoinsComponent.Factory
  fun homeComponent(): HomeComponent.Factory

  @Component.Builder
  interface Builder {

      fun build(): ApplicationComponent

      @BindsInstance
      fun application(context: Context): Builder

  }

}

@Module(subcomponents = [CoinsComponent::class])
object Subcomponents