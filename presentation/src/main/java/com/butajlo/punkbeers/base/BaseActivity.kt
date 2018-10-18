package com.butajlo.punkbeers.base

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.navigation.findNavController
import com.butajlo.daggerx.DaggerAppCompatActivity
import com.butajlo.punkbeers.lifecycle.ActivityLifecycleTask
import com.butajlo.punkbeers.navigator.Navigator
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject lateinit var navigator: Navigator

    @Inject
    @JvmSuppressWildcards
    lateinit var lifecycleTasks: Set<ActivityLifecycleTask>

    @LayoutRes
    abstract fun layoutRes(): Int

    abstract fun initFragment(): BaseFragment

    @IdRes
    abstract fun fragmentContainerRes(): Int

    @IdRes
    abstract fun navControllerRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutRes())
        lifecycleTasks.forEach { it.onCreate(this) }
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(javaClass.simpleName, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onSupportNavigateUp() = findNavController(navControllerRes()).navigateUp()

    fun getNavController() = findNavController(navControllerRes())
}