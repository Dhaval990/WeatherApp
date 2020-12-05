package com.app.weatherapp.ui.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.weatherapp.db.WeatherDataBase
import com.app.weatherapp.db.dao.BookmarkPlaceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

class DbModule {

    @Module
    @InstallIn(ApplicationComponent::class)
    class DataBaseModule {

        @Provides
        fun providesWeatherDatabase(application: Application): WeatherDataBase {
            return Room.databaseBuilder(
                application.applicationContext,
                WeatherDataBase::class.java,
                "weather_db"
            ).setJournalMode(RoomDatabase.JournalMode.AUTOMATIC).enableMultiInstanceInvalidation()
                .build()
        }

        @Provides
        @Singleton
        fun providesAccidentDescCategoryDao(weatherDataBase: WeatherDataBase): BookmarkPlaceDao {
            return weatherDataBase.bookmarkPlaceDao()
        }
    }
}
