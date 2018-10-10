package com.butajlo.punkbeers.data.repository

import com.butajlo.punkbeers.data.dao.PunkDao
import com.butajlo.punkbeers.data.mappers.toDomainModel
import com.butajlo.punkbeers.data.model.Beer
import com.butajlo.punkbeers.data.test.TestUtils
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import io.reactivex.Single
import org.junit.Test

class PunkRepositoryImplTest {

    private val beer = TestUtils.loadJson("mock/get_beer.json", Beer::class.java)

    private val punkDao = mock<PunkDao> {
        on(it.getBeer(any())).thenReturn(Single.just(beer))
        on(it.getRandomBeer()).thenReturn(Single.just(beer))
    }

    private val punkRepository = PunkRepositoryImpl(punkDao)

    @Test
    fun getRandomBeer_Success() {
        punkRepository.getRandomBeer().test().assertValue { it.name == "Punk IPA 2007 - 2010" }
    }

    @Test
    fun getBeer_NotCached() {
        //TODO: Finish test
        punkRepository.getBeer(any()).test().assertValue(beer.toDomainModel())
    }


}