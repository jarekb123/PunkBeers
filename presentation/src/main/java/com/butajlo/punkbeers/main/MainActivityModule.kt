package com.butajlo.punkbeers.main

import com.butajlo.punkbeers.di.ViewModelModule
import com.butajlo.punkbeers.repository.PunkRepository
import com.butajlo.punkbeers.screens.home.HomeFragment
import com.butajlo.punkbeers.screens.home.HomeFragmentModule
import com.butajlo.punkbeers.executor.GetRandomBeerUseCase
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = [ViewModelModule::class, HomeFragmentModule::class])
    abstract fun bindHomeFragment(): HomeFragment

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideGetRandomBeerUseCase(punkRepository: PunkRepository)
                = GetRandomBeerUseCase(punkRepository)
    }

}