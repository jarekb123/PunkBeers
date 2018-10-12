package com.butajlo.punkbeers.data.repository

import com.butajlo.punkbeers.data.dao.PunkDao
import com.butajlo.punkbeers.data.mappers.toDomainModel
import com.butajlo.punkbeers.data.model.Beer
import com.butajlo.punkbeers.data.test.TestUtils
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class PunkRepositoryImplTest {

    private val beer = TestUtils.loadJson("mock/get_beer.json", Beer::class.java)
    private val secondBeer = TestUtils.loadJson("mock/get_beer_2.json", Beer::class.java)

    private val beerList = listOf(beer, secondBeer)

    private val punkDao = mock<PunkDao> {
        on(it.getBeer(1)).thenReturn(Single.just(beer))
        on(it.getRandomBeer()).thenReturn(Single.just(beer))
        on(it.findBeers("name", "yeast", "hops")).thenReturn(Single.just(listOf(beer, secondBeer)))
    }

    private val punkRepository = PunkRepositoryImpl(punkDao)

    @Before
    fun setUp() {
        punkRepository.clearCache()
    }

    @Test
    fun findBeers_ReturnListWithTwoBeers() {
        punkRepository.findBeers("name", "yeast", "hops")
                .test()
                .assertValue(beerList.map { it.toDomainModel() })
    }

    @Test
    fun getRandomBeer_Success() {
        punkRepository.getRandomBeer()
                .test()
                .assertValue(beer.toDomainModel())
    }

    @Test
    fun getBeer_NotCached() {
        punkRepository.getBeer(1).test().assertValue(beer.toDomainModel())
        verify(punkDao).getBeer(1)
    }

    @Test
    fun getBeer_Cached() {
        punkRepository.getBeer(1).subscribe() // 1. fetch sth from DAO
        whenever(punkDao.getBeer(1)).thenReturn(Single.just(secondBeer)) // 2. DAO now return different beer

        punkRepository.getBeer(1)
                .test()
                .assertValue { it.name == beer.name } // but there is beer cached, so it should return the first one
    }


}