package com.butajlo.punkbeers.network

import com.butajlo.punkbeers.service.PunkService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Module(includes = [NetworkModule::class])
class ServiceModule {

    @Singleton
    @Provides
    @Named("base_url")
    fun provideApiUrl() = "https://api.punkapi.com/v2/"

    @Singleton
    @Provides
    fun providePunkService(retrofit: Retrofit): PunkService
            = retrofit.create(PunkService::class.java)

}