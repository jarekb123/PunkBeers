package com.butajlo.punkbeers.view.interceptor

import android.app.Activity

/**
 * This class is used for debug purposes.
 * It helps to change debug settings during whole activity life.
 */
interface ActivityViewInterceptor {

    fun setContentView(activity: Activity, layoutRes: Int)

    companion object {
        val DEFAULT = object : ActivityViewInterceptor {
            override fun setContentView(activity: Activity, layoutRes: Int) = activity.setContentView(layoutRes)
        }
    }

}