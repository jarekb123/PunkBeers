package com.butajlo.punkbeers.main

import com.butajlo.punkbeers.screens.home.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityFragmentsBuilderModule {

    @ContributesAndroidInjector
    abstract fun bindHomeFragment(): HomeFragment

}