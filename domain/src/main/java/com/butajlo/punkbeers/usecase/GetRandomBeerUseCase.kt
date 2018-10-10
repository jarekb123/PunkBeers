package com.butajlo.punkbeers.usecase

import com.butajlo.punkbeers.common.UseCase
import com.butajlo.punkbeers.model.BeerEntity
import com.butajlo.punkbeers.repository.PunkRepository
import io.reactivex.Single

class GetRandomBeerUseCase(private val punkRepository: PunkRepository) : UseCase<Single<BeerEntity>> {

    override fun execute() = punkRepository.getRandomBeer()

}