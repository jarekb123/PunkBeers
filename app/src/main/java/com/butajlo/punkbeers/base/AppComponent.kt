package com.butajlo.punkbeers.base

import com.butajlo.punkbeers.network.NetworkModule
import com.butajlo.punkbeers.network.ServiceModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Component(modules = [
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    NetworkModule::class,
    ServiceModule::class]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<App>()

}