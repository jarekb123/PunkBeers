package com.butajlo.punkbeers.view.interceptor

import dagger.Binds
import dagger.Module

@Module
abstract class ActivityInterceptorModule {

    @Binds
    abstract fun bindDebugInterceptor(debugActivityInterceptor: DebugActivityInterceptor): ActivityViewInterceptor
}