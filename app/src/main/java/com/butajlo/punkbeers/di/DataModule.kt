package com.butajlo.punkbeers.di

import com.butajlo.punkbeers.repository.PunkRepository
import com.butajlo.punkbeers.repository.PunkRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class DataModule {

    @Binds
    abstract fun providePunkRepository(punkRepositoryImpl: PunkRepositoryImpl): PunkRepository

}