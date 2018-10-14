package com.butajlo.punkbeers.network

import com.butajlo.punkbeers.data.dao.PunkDao
import dagger.Component

@NetworkScope
@Component(modules = [NetworkModule::class])
interface NetworkComponent {

    fun punkDao(): PunkDao

    @Component.Builder
    abstract class Builder {
        abstract fun build(): NetworkComponent
    }
}