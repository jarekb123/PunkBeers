package com.butajlo.punkbeers.screens.home

import androidx.lifecycle.ViewModel
import com.butajlo.punkbeers.repository.PunkRepository
import com.butajlo.punkbeers.usecase.GetRandomBeerUseCase
import com.butajlo.punkbeers.view.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class HomeModule {

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeFragmentViewModel(viewModel: HomeViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideGetRandomBeerUseCase(punkRepository: PunkRepository)
                = GetRandomBeerUseCase(punkRepository)
    }

}