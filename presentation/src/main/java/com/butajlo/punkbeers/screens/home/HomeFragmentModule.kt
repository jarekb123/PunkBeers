package com.butajlo.punkbeers.screens.home

import android.arch.lifecycle.ViewModel
import com.butajlo.punkbeers.repository.PunkRepository
import com.butajlo.punkbeers.usecase.GetRandomBeerUseCase
import com.butajlo.punkbeers.view.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class HomeFragmentModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeFragmentViewModel::class)
    abstract fun bindHomeFragmentViewModel(viewModel: HomeFragmentViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideGetRandomBeerUseCase(punkRepository: PunkRepository)
                = GetRandomBeerUseCase(punkRepository)
    }

}