package com.butajlo.punkbeers.navigator

import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import com.butajlo.punkbeers.base.BaseActivity
import com.butajlo.punkbeers.di.ActivityScope
import com.butajlo.punkbeers.lifecycle.ActivityLifecycleTask
import com.butajlo.punkbeers.screens.details.DetailsFragment
import javax.inject.Inject

@ActivityScope
class NavigatorImpl @Inject constructor() : ActivityLifecycleTask(), Navigator {

    private lateinit var navController: NavController
    override fun onCreate(activity: BaseActivity) {
        navController = activity.getNavController()
    }

    override fun goToBeerDetails(beerId: Long) {
        var bundle = bundleOf(DetailsFragment.ARGUMENT_BEER_ID to beerId)
    }

    private fun goToFragment(fragment: Fragment, tag: String? = null) {

    }

    companion object {
        private const val TAG_INIT_FRAGMENT = "TAG_INIT_FRAGMENT"
    }
}