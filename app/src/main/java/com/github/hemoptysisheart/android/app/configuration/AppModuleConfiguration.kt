package com.github.hemoptysisheart.android.app.configuration

import com.github.hemoptysisheart.core.configuration.CoreModuleConfiguration
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module(includes = [CoreModuleConfiguration::class])
@InstallIn(SingletonComponent::class)
class AppModuleConfiguration