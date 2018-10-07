package com.butajlo.punkbeers.usecase

import com.butajlo.punkbeers.repository.PunkRepository
import com.butajlo.punkbeers.common.UseCase
import com.butajlo.punkbeers.model.BeerEntity

class SearchByNameUseCase(private val punkRepository: PunkRepository) : UseCase<String, List<BeerEntity>> {

    override fun execute(params: String): List<BeerEntity> {
        return punkRepository.searchByName(params)
    }
}