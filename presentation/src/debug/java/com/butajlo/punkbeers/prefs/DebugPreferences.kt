package com.butajlo.punkbeers.prefs

import android.content.Context
import com.butajlo.punkbeers.di.AppScope
import javax.inject.Inject

@AppScope
class DebugPreferences @Inject constructor(context: Context) {

    private val sharedPrefs by lazy { context.getSharedPreferences("debug_settings", Context.MODE_PRIVATE) }

    var isMockResponsesEnabled: Boolean
        get() = sharedPrefs.getBoolean(KEY_MOCK_RESPONSES, false)
        set(value) = sharedPrefs.edit().putBoolean(KEY_MOCK_RESPONSES, value).apply()


    companion object {
        const val KEY_MOCK_RESPONSES = "KEY_MOCK_RESPONSES"
    }

}