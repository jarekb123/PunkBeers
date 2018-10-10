package com.butajlo.punkbeers.data.service

import com.butajlo.punkbeers.data.model.Beer
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface PunkService {

    @GET("beers/random")
    fun getRandomBeer(): Single<List<Beer>>

    @GET("beers/{id}")
    fun getBeer(@Path("id") id: Long): Single<List<Beer>>

}