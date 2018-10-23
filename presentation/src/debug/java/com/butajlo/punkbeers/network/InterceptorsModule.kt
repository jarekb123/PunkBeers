package com.butajlo.punkbeers.network

import com.butajlo.punkbeers.di.AppScope
import com.butajlo.punkbeers.network.mock.MockInterceptor
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet
import dagger.multibindings.Multibinds
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

@Module
abstract class InterceptorsModule {

    @Multibinds
    abstract fun bindInterceptors(): Set<@JvmSuppressWildcards Interceptor>

    @Binds
    @IntoSet
    abstract fun bindMockInterceptor(mockInterceptor: MockInterceptor): Interceptor

    @Module
    companion object {

        @AppScope
        @Provides
        fun provideLoggingInterceptor(): Interceptor {
            return HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        }
    }

}