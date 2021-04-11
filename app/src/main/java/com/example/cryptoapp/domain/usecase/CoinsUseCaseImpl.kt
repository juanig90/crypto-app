package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CoinsUseCaseImpl @Inject constructor(private val repository: CoinsRepository) : CoinsUseCase {

    override fun getCoins(): Single<List<Coin>> {
        return repository.getCoins()
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.single())
    }
}