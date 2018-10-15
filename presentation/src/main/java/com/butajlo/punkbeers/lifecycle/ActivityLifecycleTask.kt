package com.butajlo.punkbeers.lifecycle

import com.butajlo.punkbeers.base.BaseActivity

abstract class ActivityLifecycleTask {

    open fun onCreate(activity: BaseActivity) {}
    open fun onStart() {}
    open fun onResume() {}
    open fun onPause() {}
    open fun onStop() {}
    open fun onDestroy() {}

}