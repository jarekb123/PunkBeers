package com.butajlo.punkbeers.base

import com.butajlo.punkbeers.App
import com.butajlo.punkbeers.di.AppScope
import com.butajlo.punkbeers.network.NetworkComponent
import com.butajlo.punkbeers.rx.usecase.UseCaseExecutorModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

@Component(dependencies = [NetworkComponent::class],
        modules = [
            AndroidSupportInjectionModule::class,
            ActivityBuilderModule::class,
            AppModule::class,
            UseCaseExecutorModule::class
        ])
@AppScope
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>() {
        abstract fun networkComponent(networkComponent: NetworkComponent): Builder
    }

}