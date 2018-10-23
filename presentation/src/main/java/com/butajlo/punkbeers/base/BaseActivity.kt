package com.butajlo.punkbeers.base

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.navigation.findNavController
import com.butajlo.daggerx.DaggerAppCompatActivity
import com.butajlo.punkbeers.view.interceptor.ActivityViewInterceptor
import javax.inject.Inject

abstract class BaseActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var activityViewInterceptor: ActivityViewInterceptor

    @LayoutRes
    abstract fun layoutRes(): Int

    abstract fun initFragment(): BaseFragment

    @IdRes
    abstract fun fragmentContainerRes(): Int

    @IdRes
    abstract fun navControllerRes(): Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityViewInterceptor.setContentView(this, layoutRes())
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(javaClass.simpleName, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onSupportNavigateUp() = findNavController(navControllerRes()).navigateUp() }