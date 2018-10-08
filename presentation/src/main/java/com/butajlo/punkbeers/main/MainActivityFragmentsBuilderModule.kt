package com.butajlo.punkbeers.main

import com.butajlo.punkbeers.di.ViewModelModule
import com.butajlo.punkbeers.screens.home.HomeFragment
import com.butajlo.punkbeers.screens.home.HomeFragmentModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, ViewModelModule::class, HomeFragmentModule::class])
    abstract fun bindHomeFragment(): HomeFragment

}