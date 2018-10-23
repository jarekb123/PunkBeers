package com.butajlo.punkbeers.base

import com.butajlo.punkbeers.di.ActivityScope
import com.butajlo.punkbeers.main.MainActivity
import com.butajlo.punkbeers.main.MainActivityModule
import com.butajlo.punkbeers.view.interceptor.ActivityInterceptorModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, ActivityInterceptorModule::class])
    abstract fun bindMainActivity(): MainActivity


}