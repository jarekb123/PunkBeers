package com.butajlo.punkbeers.navigator

import com.butajlo.punkbeers.base.BaseFragment

interface Navigator {

    fun init(fragment: BaseFragment)
    fun goToBeerDetails(beerId: Long)
}