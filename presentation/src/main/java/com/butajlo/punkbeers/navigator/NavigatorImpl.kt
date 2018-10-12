package com.butajlo.punkbeers.navigator

import android.support.annotation.IdRes
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.butajlo.punkbeers.base.BaseActivity
import com.butajlo.punkbeers.di.ActivityScope
import com.butajlo.punkbeers.screens.details.DetailsFragment
import javax.inject.Inject

@ActivityScope
class NavigatorImpl @Inject constructor(): Navigator {

    private lateinit var fragmentManager: FragmentManager

    @IdRes
    private var fragmentContainerRes: Int = 0

    override fun init(activity: BaseActivity) {
        fragmentManager = activity.supportFragmentManager
        fragmentContainerRes = activity.fragmentContainerRes()

        goToFragment(activity.initFragment())
    }

    override fun goToBeerDetails(beerId: Long) {
        goToFragment(DetailsFragment.create(beerId))
    }

    private fun goToFragment(fragment: Fragment) {
        fragmentManager.beginTransaction()
                .replace(fragmentContainerRes, fragment)
                .commit()
    }
}