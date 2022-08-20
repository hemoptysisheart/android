package com.github.hemoptysisheart.android.app.configuration

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey
import com.github.hemoptysisheart.core.model.PreferencesModel
import com.github.hemoptysisheart.domain.preferences.Preferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModuleConfiguration {
    companion object {
        val TAG = AppModuleConfiguration::class.simpleName
    }

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        Log.i(TAG, "#provideSharedPreferences args : context=$context")

        val sharedPreferences = EncryptedSharedPreferences.create(
            context,
            "com.github.hemoptysisheart.app.encryptedSharedPreferences",
            MasterKey.Builder(context)
                .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
                .build(),
            EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
            EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
        )

        Log.i(TAG, "#provideSharedPreferences return : $sharedPreferences")
        return sharedPreferences
    }

    @Provides
    @Singleton
    fun providePreference(sharedPreferences: SharedPreferences): Preferences {
        val preferences = PreferencesModel(sharedPreferences)

        Log.i(TAG, "#providePreferenceModel return : $preferences")
        return preferences
    }
}