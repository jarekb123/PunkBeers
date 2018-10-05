package com.butajlo.punkbeers.base

import com.butajlo.punkbeers.main.MainActivity
import com.butajlo.punkbeers.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity(): MainActivity

}
