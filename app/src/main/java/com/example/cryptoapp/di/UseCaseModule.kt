package com.example.cryptoapp.di

import com.example.cryptoapp.domain.repository.CoinsRepository
import com.example.cryptoapp.domain.usecase.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
object UseCaseModule {

    @Singleton
    @Provides
    fun providesSelectionCoinUseCase(coinsRepository: CoinsRepository): SelectionCoinUseCase {
       return SelectionCoinUseCaseImpl(coinsRepository)
    }

    @Singleton
    @Provides
    fun providesFavoriteCoinUseCase(coinsRepository: CoinsRepository): FavoriteCoinUseCase {
        return FavoriteCoinUseCaseImpl(coinsRepository)
    }

    @Singleton
    @Provides
    fun providesCoinDetailUseCase(coinsRepository: CoinsRepository): CoinDetailUseCase {
        return CoinDetailUseCaseImpl(coinsRepository)
    }

    @Singleton
    @Provides
    fun providesSaveFavoriteUseCase(coinsRepository: CoinsRepository): SaveFavoriteUseCase {
        return SaveFavoriteUseCaseImpl(coinsRepository)
    }

    @Singleton
    @Provides
    fun providesRemoveFavoriteUseCase(coinsRepository: CoinsRepository): RemoveFavoriteUseCase {
        return RemoveFavoriteUseCaseImpl(coinsRepository)
    }

}