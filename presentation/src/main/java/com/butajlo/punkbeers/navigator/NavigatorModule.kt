package com.butajlo.punkbeers.navigator

import com.butajlo.punkbeers.lifecycle.ActivityLifecycleTask
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet

@Module
abstract class NavigatorModule {

    @Binds
    abstract fun bindNavigator(navigatorImpl: NavigatorImpl): Navigator

    @Binds
    @IntoSet
    abstract fun bindNavigatorTask(navigatorImpl: NavigatorImpl): ActivityLifecycleTask
}