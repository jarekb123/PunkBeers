package com.butajlo.punkbeers.usecase

import com.butajlo.punkbeers.repository.PunkRepository
import com.butajlo.punkbeers.common.UseCase
import com.butajlo.punkbeers.model.Beer

class SearchByNameUseCase(private val punkRepository: PunkRepository) : UseCase<String, List<Beer>> {

    override fun execute(params: String): List<Beer> {
        return punkRepository.searchByName(params)
    }
}