package com.butajlo.punkbeers.data.repository

import com.butajlo.punkbeers.data.dao.PunkDao
import com.butajlo.punkbeers.data.mappers.toDomainModel
import com.butajlo.punkbeers.model.BeerEntity
import com.butajlo.punkbeers.repository.PunkRepository
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class PunkRepositoryImpl @Inject constructor(private val punkDao: PunkDao) : PunkRepository {

    private val cachedBeerEntities = mutableListOf<BeerEntity>()

    override fun getRandomBeer(): Single<BeerEntity> = punkDao.getRandomBeer().map { it.toDomainModel() }

    override fun getBeer(id: Long): Single<BeerEntity> {
        return Maybe.concat(getCachedBeerEntity(id), getBeerEntityFromDao(id))
                .firstOrError()
    }

    private fun getCachedBeerEntity(id: Long): Maybe<BeerEntity> {
        return Maybe.create { e ->
            cachedBeerEntities.firstOrNull { it.id == id }?.also {
                e.onSuccess(it)
            }
            e.onComplete()
        }
    }

    private fun getBeerEntityFromDao(id: Long): Maybe<BeerEntity> {
        return punkDao.getBeer(id)
                .map { it.toDomainModel() }
                .toMaybe()
    }

}