package com.butajlo.punkbeers.base

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import com.butajlo.punkbeers.navigator.Navigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject lateinit var navigator: Navigator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())

        navigator.init(this)
    }

    @LayoutRes
    abstract fun layoutRes(): Int

    abstract fun initFragment(): Fragment

    @IdRes
    abstract fun fragmentContainerRes(): Int

}