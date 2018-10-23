package com.butajlo.punkbeers.network

import com.butajlo.punkbeers.di.AppScope
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Named

@Module
object ServiceModule {

    @AppScope
    @Provides
    @IntoSet
    @JvmStatic
    fun provideLoggingInterceptor(): Interceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @AppScope
    @Provides
    @Named("base_url")
    @JvmStatic
    fun provideApiUrl() = "https://api.punkapi.com/v2/"
}