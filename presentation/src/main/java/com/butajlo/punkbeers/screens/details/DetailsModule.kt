package com.butajlo.punkbeers.screens.details

import android.arch.lifecycle.ViewModel
import com.butajlo.punkbeers.repository.PunkRepository
import com.butajlo.punkbeers.usecase.GetBeerUseCase
import com.butajlo.punkbeers.view.viewmodel.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
abstract class DetailsModule {

    @Binds
    @IntoMap
    @ViewModelKey(DetailsViewModel::class)
    abstract fun bindDetailsViewModel(detailsViewModel: DetailsViewModel): ViewModel

    @Module
    companion object {
        @JvmStatic
        @Provides
        fun provideGetBeerUseCase(punkRepository: PunkRepository) = GetBeerUseCase(punkRepository)
    }

}
