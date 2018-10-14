package com.butajlo.punkbeers.rx

import com.butajlo.punkbeers.di.AppScope
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Named
import javax.inject.Singleton

@Module
class SchedulersModule {

    @AppScope
    @Provides
    @Named("io_scheduler")
    fun provideIOScheduler() = Schedulers.io()

    @AppScope
    @Provides
    @Named("ui_scheduler")
    fun provideUIScheduler() = AndroidSchedulers.mainThread()

}