package com.butajlo.punkbeers.repository

import com.butajlo.punkbeers.model.BeerEntity
import io.reactivex.Single

interface PunkRepository {
    fun getRandomBeer(): Single<BeerEntity>

    fun getBeer(id: Long): Single<BeerEntity>

    fun findBeers(name: String? = null, yeast: String? = null, hops: String? = null): Single<List<BeerEntity>>
}