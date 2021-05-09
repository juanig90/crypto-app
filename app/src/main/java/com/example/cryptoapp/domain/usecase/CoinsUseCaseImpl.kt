package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.domain.entity.Coin
import com.example.cryptoapp.domain.repository.CoinsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CoinsUseCaseImpl @Inject constructor(private val repository: CoinsRepository) : CoinsUseCase {

    override fun getCoins(local: Boolean): Single<List<Coin>> {
        return repository.getCoins(local)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun saveCoin(coin: Coin): Completable {
        return repository.saveCoin(coin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun deleteCoin(coin: Coin): Completable {
        return repository.deleteCoin(coin)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}