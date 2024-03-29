package com.example.cryptoapp.di

import android.content.Context
import com.example.cryptoapp.presentation.coins.di.CoinsComponent
import com.example.cryptoapp.presentation.detail.di.DetailComponent
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
        UseCaseModule::class,
        ViewModelBuilderModule::class
    ]
)
interface ApplicationComponent {

  fun coinsComponent(): CoinsComponent.Factory
  fun homeComponent(): HomeComponent.Factory
  fun detailComponent(): DetailComponent.Factory

  @Component.Builder
  interface Builder {

      fun build(): ApplicationComponent

      @BindsInstance
      fun application(context: Context): Builder

  }

}

@Module(subcomponents = [HomeComponent::class, CoinsComponent::class, DetailComponent::class])
object Subcomponents