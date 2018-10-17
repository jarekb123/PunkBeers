package com.butajlo.punkbeers.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.butajlo.punkbeers.daggerx.DaggerFragment

abstract class BaseFragment : DaggerFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        return inflater.inflate(layoutRes(), container, false)
    }

    @LayoutRes
    abstract fun layoutRes(): Int

}