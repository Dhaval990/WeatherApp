package com.app.weatherapp.di

import android.app.Application
import com.app.weatherapp.utils.AppPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class CommonModule {

    @Provides
    fun provideAppPreferences(application: Application): AppPreferences {
        return AppPreferences(application.applicationContext)
    }
}