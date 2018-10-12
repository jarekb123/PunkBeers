package com.butajlo.punkbeers.navigator

import com.butajlo.punkbeers.base.BaseActivity

interface Navigator {

    fun init(activity: BaseActivity)
    fun goToBeerDetails(beerId: Long)
}