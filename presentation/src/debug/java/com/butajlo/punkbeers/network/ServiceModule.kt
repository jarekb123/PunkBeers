package com.butajlo.punkbeers.network

import com.butajlo.punkbeers.di.AppScope
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
object ServiceModule {

    @AppScope
    @Provides
    @Named("base_url")
    @JvmStatic
    fun provideApiUrl() = "https://api.punkapi.com/v2/"

}