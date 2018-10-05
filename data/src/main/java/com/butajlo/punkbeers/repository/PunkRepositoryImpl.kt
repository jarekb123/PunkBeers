package com.butajlo.punkbeers.repository

import com.butajlo.punkbeers.mappers.map
import com.butajlo.punkbeers.model.Beer
import com.butajlo.punkbeers.service.PunkService
import io.reactivex.Observable
import javax.inject.Inject

class PunkRepositoryImpl @Inject constructor(private val punkService: PunkService) : PunkRepository {

    override fun getRandomBeer(): Observable<Beer> = punkService.getRandomBeer().map { it.map() }

    override fun searchByName(name: String) : List<Beer> {
        Thread.sleep(1000)
        return listOf(Beer(1, "BeerEntity"))
    }
}