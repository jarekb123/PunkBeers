package com.butajlo.punkbeers.view.interceptor

import dagger.Module
import dagger.Provides

@Module
object ActivityInterceptorModule {

    @Provides
    @JvmStatic
    fun provideActivityInterceptor() = ActivityViewInterceptor.DEFAULT

}