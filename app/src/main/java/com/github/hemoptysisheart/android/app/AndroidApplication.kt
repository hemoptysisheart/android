package com.github.hemoptysisheart.android.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class AndroidApplication : Application() {
    companion object {
        val TAG = AndroidApplication::class.simpleName
    }
}