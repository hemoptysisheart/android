package com.github.hemoptysisheart.android.app.viewmodel

import androidx.lifecycle.ViewModel
import com.github.hemoptysisheart.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TutorialPrefViewModel @Inject constructor(
    private val preferences: Preferences
) : ViewModel() {
    companion object {
        val TAG = TutorialPrefViewModel::class.simpleName
    }

    var enable: Boolean
        get() = preferences.tutorial.enable
        set(value) {
            preferences.tutorial.enable = value
        }

    override fun toString() = "$TAG(preferences=$preferences, enable=$enable)"
}
