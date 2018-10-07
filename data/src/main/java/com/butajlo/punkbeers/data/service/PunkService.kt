package com.butajlo.punkbeers.data.service

import com.butajlo.punkbeers.data.model.Beer
import io.reactivex.Observable
import retrofit2.http.GET

interface PunkService {

    @GET("beers/random")
    fun getRandomBeer(): Observable<List<Beer>>

}