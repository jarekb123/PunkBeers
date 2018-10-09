package com.butajlo.punkbeers.di

import com.butajlo.punkbeers.App
import com.butajlo.punkbeers.executor.UseCaseExecutorModule
import com.butajlo.punkbeers.network.DataModule
import com.butajlo.punkbeers.rx.SchedulersModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    AppModule::class,
    DataModule::class,
    UseCaseExecutorModule::class
])
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}