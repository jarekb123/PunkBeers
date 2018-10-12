package com.butajlo.punkbeers.data.repository

import com.butajlo.punkbeers.data.dao.PunkDao
import com.butajlo.punkbeers.data.mappers.toDomainModel
import com.butajlo.punkbeers.model.BeerEntity
import com.butajlo.punkbeers.repository.PunkRepository
import io.reactivex.Maybe
import io.reactivex.Single
import org.jetbrains.annotations.TestOnly
import javax.inject.Inject

/**
 * Repository which is used to fetch BeerEntity objects used by use cases.
 * This repo stores cache, which contains previous fetched BeerEntities.
 */
class PunkRepositoryImpl @Inject constructor(private val punkDao: PunkDao) : PunkRepository {
    private val cachedBeerEntities = mutableListOf<BeerEntity>()

    /**
     * Get random BeerEntity.
     * The fetched object is NOT cached.
     */
    override fun getRandomBeer(): Single<BeerEntity> = punkDao.getRandomBeer().map { it.toDomainModel() }

    /**
     * Get BeerEntity with provided id.
     * @param id BeerEntity's id
     * @return Cached BeerEntity if exists, otherwise returns BeerEntity fetched from PunkDao
     */
    override fun getBeer(id: Long): Single<BeerEntity> = Maybe.concat(getCachedBeerEntity(id), getBeerEntityFromDao(id))
            .firstOrError()

    /**
     * Find beers with provided name, yeast or hops
     * @return Found beers
     */
    override fun findBeers(name: String?, yeast: String?, hops: String?): Single<List<BeerEntity>> {
        return punkDao.findBeers(name, yeast, hops)
                .map {
                    it.map { it.toDomainModel() }
                }
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
                .doOnSuccess {
                    cachedBeerEntities.removeIf { entity -> entity.id == id }
                    cachedBeerEntities.add(it)
                }
                .toMaybe()
    }

    @TestOnly
    fun clearCache() = cachedBeerEntities.clear()

}