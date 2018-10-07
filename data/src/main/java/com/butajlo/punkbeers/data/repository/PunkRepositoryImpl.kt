package com.butajlo.punkbeers.data.repository

import com.butajlo.punkbeers.data.dao.PunkDao
import com.butajlo.punkbeers.data.mappers.toDomainModel
import com.butajlo.punkbeers.model.BeerEntity
import com.butajlo.punkbeers.repository.PunkRepository
import io.reactivex.Observable
import javax.inject.Inject

class PunkRepositoryImpl @Inject constructor(private val punkDao: PunkDao) : PunkRepository {

    override fun getRandomBeer(): Observable<BeerEntity> = punkDao.getRandomBeer().map { it.toDomainModel() }

    override fun searchByName(name: String) : List<BeerEntity> {
        Thread.sleep(1000)
        return listOf(BeerEntity(1, "Beer"))
    }
}