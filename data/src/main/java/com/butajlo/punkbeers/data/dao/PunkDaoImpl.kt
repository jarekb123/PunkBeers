package com.butajlo.punkbeers.data.dao

import com.butajlo.punkbeers.data.model.Beer
import com.butajlo.punkbeers.data.service.PunkService
import io.reactivex.Observable
import javax.inject.Inject


class PunkDaoImpl @Inject constructor(private val punkService: PunkService) : PunkDao {

    override fun getRandomBeer(): Observable<Beer> = punkService.getRandomBeer().map { it[0] }

}