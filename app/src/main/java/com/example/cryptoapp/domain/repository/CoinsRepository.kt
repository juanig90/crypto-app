package com.example.cryptoapp.domain.repository

import com.example.cryptoapp.data.Result
import com.example.cryptoapp.domain.entity.OptionItemUI
import com.example.cryptoapp.domain.entity.DetailUI
import com.example.cryptoapp.domain.entity.FavoriteItemUI
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CoinsRepository {

    fun getOptionItems(): Single<Result<List<OptionItemUI>>>
    fun getFavoriteItems(): Single<Result<List<FavoriteItemUI>>>
    fun saveFavorite(item: OptionItemUI): Completable
    fun removeFavorite(item: OptionItemUI): Completable
    fun getDetail(id: String): Single<Result<DetailUI>>
}