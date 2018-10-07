package com.butajlo.punkbeers.di

import com.butajlo.punkbeers.data.repository.PunkRepositoryImpl
import com.butajlo.punkbeers.repository.PunkRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class AppModule {

    @Singleton
    @Binds
    abstract fun providePunkRepository(punkRepositoryImpl: PunkRepositoryImpl): PunkRepository

}