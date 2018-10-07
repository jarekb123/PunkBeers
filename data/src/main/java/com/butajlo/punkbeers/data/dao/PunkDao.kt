package com.butajlo.punkbeers.data.dao

import com.butajlo.punkbeers.data.model.Beer
import io.reactivex.Observable

interface PunkDao {
    fun getRandomBeer(): Observable<Beer>
}