package com.butajlo.punkbeers.navigator

import dagger.Binds
import dagger.Module

@Module
abstract class NavigatorModule {

    @Binds
    abstract fun provideNavigator(navigatorImpl: NavigatorImpl): Navigator
}