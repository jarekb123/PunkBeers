package com.butajlo.punkbeers.base

import com.butajlo.punkbeers.App
import com.butajlo.punkbeers.data.repository.PunkRepositoryImpl
import com.butajlo.punkbeers.di.AppScope
import com.butajlo.punkbeers.repository.PunkRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
abstract class AppModule {

    @AppScope
    @Binds
    abstract fun providePunkRepository(punkRepositoryImpl: PunkRepositoryImpl): PunkRepository

    @Module
    companion object {

        @AppScope
        @Provides
        fun provideAppContext(app: App) = app.applicationContext
    }

}