package com.butajlo.punkbeers.usecase

import com.butajlo.punkbeers.common.UseCase
import com.butajlo.punkbeers.model.BeerEntity
import com.butajlo.punkbeers.repository.PunkRepository
import io.reactivex.Observable

class GetRandomBeerUseCase(private val punkRepository: PunkRepository) : UseCase<Unit, Observable<BeerEntity>> {

    override fun execute(params: Unit?): Observable<BeerEntity> = punkRepository.getRandomBeer()

}