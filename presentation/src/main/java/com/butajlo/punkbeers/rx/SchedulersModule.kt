package com.butajlo.punkbeers.rx

import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class SchedulersModule {

    @Singleton
    @Provides
    @Named("io_scheduler")
    fun provideIOScheduler() = Schedulers.io()

    @Singleton
    @Provides
    @Named("ui_scheduler")
    fun provideUIScheduler() = AndroidSchedulers.mainThread()

}