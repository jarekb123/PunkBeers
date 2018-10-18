package com.butajlo.punkbeers.main

import com.butajlo.punkbeers.R
import com.butajlo.punkbeers.base.BaseActivity
import com.butajlo.punkbeers.screens.home.HomeFragment

class MainActivity : BaseActivity() {

    override fun fragmentContainerRes() = R.id.fragment_container

    override fun layoutRes(): Int = R.layout.activity_main

    override fun initFragment() = HomeFragment()

    override fun navControllerRes() = R.id.nav_host_fragment

}