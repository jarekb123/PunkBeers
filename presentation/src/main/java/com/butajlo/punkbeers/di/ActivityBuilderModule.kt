package com.butajlo.punkbeers.di

import com.butajlo.punkbeers.main.MainActivity
import com.butajlo.punkbeers.main.MainActivityModule
import com.butajlo.punkbeers.navigator.NavigatorModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = [MainActivityModule::class, NavigatorModule::class])
    abstract fun bindMainActivity(): MainActivity


}