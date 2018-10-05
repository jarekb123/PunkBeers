package com.butajlo.punkbeers.repository

import com.butajlo.punkbeers.model.Beer
import io.reactivex.Observable

interface PunkRepository {
    fun searchByName(name: String) : List<Beer>
    fun getRandomBeer(): Observable<Beer>
}