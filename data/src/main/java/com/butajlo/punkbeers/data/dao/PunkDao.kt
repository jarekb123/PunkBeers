package com.butajlo.punkbeers.data.dao

import com.butajlo.punkbeers.data.model.Beer
import io.reactivex.Single

interface PunkDao {
    fun getRandomBeer(): Single<Beer>
    fun getBeer(id: Long): Single<Beer>
}