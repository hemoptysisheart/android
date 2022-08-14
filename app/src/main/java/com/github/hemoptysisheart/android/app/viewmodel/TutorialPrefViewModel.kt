package com.github.hemoptysisheart.android.app.viewmodel

import androidx.lifecycle.ViewModel
import com.github.hemoptysisheart.domain.preferences.Preferences
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TutorialPrefViewModel @Inject constructor() : ViewModel() {
    companion object {
        val TAG = TutorialPrefViewModel::class.simpleName
    }

    @Inject
    lateinit var preferences: Preferences

    var enable: Boolean
        get() = preferences.tutorial.enable
        set(value) {
            preferences.tutorial.enable = value
        }

    override fun toString() = "$TAG(preferences=$preferences, enable=$enable)"
}