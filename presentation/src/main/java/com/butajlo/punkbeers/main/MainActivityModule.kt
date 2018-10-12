package com.butajlo.punkbeers.main

import com.butajlo.punkbeers.view.viewmodel.ViewModelModule
import com.butajlo.punkbeers.repository.PunkRepository
import com.butajlo.punkbeers.screens.home.HomeFragment
import com.butajlo.punkbeers.screens.home.HomeFragmentModule
import com.butajlo.punkbeers.usecase.GetRandomBeerUseCase
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class, HomeFragmentModule::class])
    abstract fun bindHomeFragment(): HomeFragment

}