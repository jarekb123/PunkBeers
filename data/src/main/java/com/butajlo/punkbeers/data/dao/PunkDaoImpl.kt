package com.butajlo.punkbeers.data.dao

import com.butajlo.punkbeers.data.model.Beer
import com.butajlo.punkbeers.data.service.PunkService
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject


class PunkDaoImpl @Inject constructor(private val punkService: PunkService) : PunkDao {

    override fun getRandomBeer(): Single<Beer> = punkService.getRandomBeer().map { it[0] }

    override fun getBeer(id: Long): Single<Beer> = punkService.getBeer(id).map { it[0] }

    override fun findBeers(name: String?, yeast: String?, hops: String?) : Single<List<Beer>> {
        val searchParams = HashMap<String, String>()

        name?.also { searchParams["name"] = it }
        yeast?.also { searchParams["yeast"] = it }
        hops?.also { searchParams["hops"] = it }

        return punkService.findBeers(searchParams)
    }
}