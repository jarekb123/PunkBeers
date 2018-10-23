package com.butajlo.punkbeers.main

import com.butajlo.punkbeers.di.FragmentScope
import com.butajlo.punkbeers.screens.details.DetailsFragment
import com.butajlo.punkbeers.screens.details.DetailsModule
import com.butajlo.punkbeers.screens.home.HomeFragment
import com.butajlo.punkbeers.screens.home.HomeModule
import com.butajlo.punkbeers.view.interceptor.ActivityInterceptorModule
import com.butajlo.punkbeers.view.viewmodel.ViewModelModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = [ViewModelModule::class, HomeModule::class])
    abstract fun bindHomeFragment(): HomeFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [ViewModelModule::class, DetailsModule::class])
    abstract fun bindDetailsFragment(): DetailsFragment

}