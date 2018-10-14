package com.butajlo.punkbeers

import com.butajlo.punkbeers.base.DaggerAppComponent
import com.butajlo.punkbeers.network.DaggerNetworkComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class App : DaggerApplication() {

    private val networkComponent by lazy { DaggerNetworkComponent.create() }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
                .networkComponent(networkComponent)
                .create(this)
    }
}