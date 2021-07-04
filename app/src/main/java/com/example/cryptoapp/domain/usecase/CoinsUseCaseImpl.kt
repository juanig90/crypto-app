package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.ErrorMapper
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import javax.inject.Inject

class CoinsUseCaseImpl @Inject constructor(
    private val repository: CoinsRepository,
    private val errorMapper: ErrorMapper) : CoinsUseCase {

    override fun getOptionItems(): Single<Result<List<OptionItemUI>>> {
        return repository.getOptionItems()
            .onErrorResumeNext {
                val msg = errorMapper.mapError(it)
                Single.just(Result.Error(msg))
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getFavoriteItems(): Single<Result<List<FavoriteItemUI>>> {
        return repository.getFavoriteItems()
            .onErrorResumeNext {
                val msg = errorMapper.mapError(it)
                Single.just(Result.Error(msg))
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun getDetail(id: String): Single<Result<DetailUI>> {
        return repository.getDetail(id)
            .onErrorResumeNext {
                val msg = errorMapper.mapError(it)
                Single.just(Result.Error(msg))
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun saveFavorite(item: OptionItemUI): Completable {
        return repository.saveFavorite(item)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun removeFavorite(item: OptionItemUI): Completable {
        return repository.removeFavorite(item)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}