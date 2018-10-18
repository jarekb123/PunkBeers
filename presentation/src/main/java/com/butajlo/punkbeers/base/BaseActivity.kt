package com.butajlo.punkbeers.base

import android.os.Bundle
import android.util.Log
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.navigation.findNavController
import com.butajlo.daggerx.DaggerAppCompatActivity

abstract class BaseActivity : DaggerAppCompatActivity() {

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
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        Log.d(javaClass.simpleName, "onSaveInstanceState")
        super.onSaveInstanceState(outState)
    }

    override fun onSupportNavigateUp() = findNavController(navControllerRes()).navigateUp() }