package com.github.hemoptysisheart.core.model

import android.content.SharedPreferences
import com.github.hemoptysisheart.domain.preferences.TutorialPref

class TutorialPrefModel(
    private val sharedPreferences: SharedPreferences,
    private val editor: SharedPreferences.Editor = sharedPreferences.edit()
) : TutorialPref {
    companion object {
        val TAG = TutorialPrefModel::class.simpleName

        private const val KEY_PREFIX = "TUTORIAL"
        const val KEY_ENABLE = "${KEY_PREFIX}_ENABLE"
    }

    init {
        if (!sharedPreferences.getBoolean(KEY_ENABLE, false)) {
            editor.putBoolean(KEY_ENABLE, false)
            editor.apply()
        }
    }

    override var enable: Boolean
        get() = sharedPreferences.getBoolean(KEY_ENABLE, false)
        internal set(value) {
            editor.putBoolean(KEY_ENABLE, value)
            editor.apply()
        }

    override fun toString() = "{enable: $enable}"
}