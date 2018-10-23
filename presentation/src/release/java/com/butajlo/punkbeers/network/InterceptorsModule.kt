package com.butajlo.punkbeers.network

import dagger.Module
import dagger.multibindings.Multibinds
import okhttp3.Interceptor

@Module
abstract class InterceptorsModule {

    @Multibinds
    abstract fun bindInterceptors(): Set<@JvmSuppressWildcards Interceptor>

}