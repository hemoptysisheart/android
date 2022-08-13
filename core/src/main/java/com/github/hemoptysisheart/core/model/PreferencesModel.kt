package com.github.hemoptysisheart.core.model

import android.content.SharedPreferences
import com.github.hemoptysisheart.domain.preferences.Preferences
import com.github.hemoptysisheart.domain.preferences.TutorialPref

class PreferencesModel(
    private val sharedPreferences: SharedPreferences,
    private var editor: SharedPreferences.Editor = sharedPreferences.edit()
) : Preferences {
    companion object {
        val TAG = PreferencesModel::class.simpleName
    }

    override val tutorial: TutorialPref
        get() = TutorialPrefModel(sharedPreferences, editor)

    override fun toString() = "{tutorial: $tutorial}"
}