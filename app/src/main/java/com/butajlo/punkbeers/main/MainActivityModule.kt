package com.butajlo.punkbeers.main

import com.butajlo.punkbeers.repository.PunkRepository
import com.butajlo.punkbeers.usecase.GetRandomBeerUseCase
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideGetRandomBeerUseCase(punkRepository: PunkRepository)
            = GetRandomBeerUseCase(punkRepository)

}