package com.butajlo.punkbeers.usecase

import com.butajlo.punkbeers.common.ParametrizedUseCase
import com.butajlo.punkbeers.model.BeerEntity
import com.butajlo.punkbeers.repository.PunkRepository
import io.reactivex.Single

class GetBeerUseCase(private val punkRepository: PunkRepository) : ParametrizedUseCase<Long, Single<BeerEntity>> {

    @Suppress("PARAMETER_NAME_CHANGED_ON_OVERRIDE")
    override fun execute(id: Long) = punkRepository.getBeer(id)
}