package com.github.hemoptysisheart.android.app

import android.app.Application
import android.util.Log
import com.github.hemoptysisheart.domain.preferences.Preferences
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class AndroidApplication : Application() {
    companion object {
        val TAG = AndroidApplication::class.simpleName
    }

    @Inject
    lateinit var preferences: Preferences

    override fun onCreate() {
        Log.i(TAG, "#onCreate start.")
        super.onCreate()

        Log.v(TAG, "#onCreate : preferences=$preferences")
    }
}