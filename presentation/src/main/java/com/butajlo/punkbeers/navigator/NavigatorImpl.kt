package com.butajlo.punkbeers.navigator

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.util.Log
import com.butajlo.punkbeers.base.BaseActivity
import com.butajlo.punkbeers.base.BaseFragment
import com.butajlo.punkbeers.di.ActivityScope
import com.butajlo.punkbeers.lifecycle.ActivityLifecycleTask
import com.butajlo.punkbeers.screens.details.DetailsFragment
import javax.inject.Inject

@ActivityScope
class NavigatorImpl @Inject constructor() : ActivityLifecycleTask(), Navigator {

    private lateinit var fragmentManager: FragmentManager

    @IdRes
    private var fragmentContainerRes: Int = 0

    private lateinit var activity: BaseActivity

    override fun onCreate(activity: BaseActivity) {
        fragmentManager = activity.supportFragmentManager
        fragmentContainerRes = activity.fragmentContainerRes()
        this.activity = activity
    }

    override fun init(fragment: BaseFragment) {
        goToFragment(fragment, TAG_INIT_FRAGMENT)
    }

    override fun goToBeerDetails(beerId: Long) {
        goToFragment(DetailsFragment.create(beerId))
    }

    private fun goToFragment(fragment: Fragment, tag: String? = null) {
        if (!activity.isDestroyed)
            fragmentManager.beginTransaction()
                    .add(fragmentContainerRes, fragment, tag)
                    .addToBackStack(null)
                    .commit()
    }

    companion object {
        private const val TAG_INIT_FRAGMENT = "TAG_INIT_FRAGMENT"
    }
}