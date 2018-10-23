package com.butajlo.punkbeers.base

import com.butajlo.punkbeers.App
import com.butajlo.punkbeers.di.AppScope
import com.butajlo.punkbeers.network.NetworkModule
import com.butajlo.punkbeers.rx.usecase.UseCaseExecutorModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(modules = [
            AndroidSupportInjectionModule::class,
            ActivityBuilderModule::class,
            AppModule::class,
            NetworkModule::class,
            UseCaseExecutorModule::class
        ])
@AppScope
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}