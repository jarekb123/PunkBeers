package com.butajlo.punkbeers.base

import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import com.butajlo.punkbeers.lifecycle.ActivityLifecycleTask
import com.butajlo.punkbeers.navigator.Navigator
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject lateinit var navigator: Navigator

    @Inject
    @JvmSuppressWildcards
    lateinit var lifecycleTasks: Set<ActivityLifecycleTask>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
        lifecycleTasks.forEach { it.onCreate(this) }
        if(savedInstanceState == null) {
            navigator.init(initFragment())
        }
    }

    @LayoutRes
    abstract fun layoutRes(): Int

    abstract fun initFragment(): BaseFragment

    @IdRes
    abstract fun fragmentContainerRes(): Int

}