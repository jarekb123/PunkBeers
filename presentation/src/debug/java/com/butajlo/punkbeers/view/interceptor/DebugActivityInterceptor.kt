package com.butajlo.punkbeers.view.interceptor

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Switch
import com.butajlo.punkbeers.R
import com.butajlo.punkbeers.prefs.DebugPreferences
import javax.inject.Inject

class DebugActivityInterceptor @Inject constructor(private val debugPreferences: DebugPreferences)
    : ActivityViewInterceptor {

    private lateinit var debugLayout: View

    override fun setContentView(activity: Activity, layoutRes: Int) {
        debugLayout = LayoutInflater.from(activity).inflate(R.layout.debug_drawer, null)
        initDebugPrefs()

        val activityLayout = LayoutInflater.from(activity).inflate(layoutRes, null)
        debugLayout.findViewById<ViewGroup>(R.id.debug_activity_container).addView(activityLayout)
        activity.setContentView(debugLayout)
    }

    private fun initDebugPrefs() {
        debugLayout.findViewById<Switch>(R.id.sw_mock_responses).apply {
            isChecked = debugPreferences.isMockResponsesEnabled
            setOnCheckedChangeListener { _, isChecked -> debugPreferences.isMockResponsesEnabled = isChecked }
        }
    }

}