package com.example.cryptoapp.domain.usecase

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.repository.CoinsRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CoinsUseCaseImpl @Inject constructor(private val repository: CoinsRepository) : CoinsUseCase {

    override fun getOptionItems(): Single<Result<List<OptionItemUI>>> {
        return repository.getOptionItems()
    }

    override fun getFavoriteItems(): Single<Result<List<FavoriteItemUI>>> {
        return repository.getFavoriteItems()
    }

    override fun getDetail(id: String): Single<Result<DetailUI>> {
        return repository.getDetail(id)
    }

    override fun saveFavorite(item: OptionItemUI): Completable {
        return repository.saveFavorite(item)
    }

    override fun removeFavorite(item: OptionItemUI): Completable {
        return repository.removeFavorite(item)
    }
}