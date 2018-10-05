package com.butajlo.punkbeers.service

import com.butajlo.punkbeers.model.BeerEntity
import io.reactivex.Observable
import retrofit2.http.GET

interface PunkService {

    @GET("/beers/random")
    fun getRandomBeer(): Observable<BeerEntity>

}