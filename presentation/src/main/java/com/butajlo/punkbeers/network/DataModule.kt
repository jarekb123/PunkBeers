package com.butajlo.punkbeers.network

import com.butajlo.punkbeers.data.dao.PunkDao
import com.butajlo.punkbeers.data.dao.PunkDaoImpl
import com.butajlo.punkbeers.data.service.PunkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class DataModule {

    @Singleton
    @Provides
    @Named("base_url")
    fun provideApiUrl() = "https://api.punkapi.com/v2/"

    @Singleton
    @Provides
    fun providePunkService(retrofit: Retrofit): PunkService
            = retrofit.create(PunkService::class.java)

    @Singleton
    @Provides
    fun providePunkDao(punkService: PunkService): PunkDao = PunkDaoImpl(punkService)

}