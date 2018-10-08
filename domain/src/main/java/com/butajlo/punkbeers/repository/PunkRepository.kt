package com.butajlo.punkbeers.repository

import com.butajlo.punkbeers.model.BeerEntity
import io.reactivex.Observable

interface PunkRepository {
    fun getRandomBeer(): Observable<BeerEntity>
}