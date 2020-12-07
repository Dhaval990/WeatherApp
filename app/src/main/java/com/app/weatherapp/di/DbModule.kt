package com.app.weatherapp.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.app.weatherapp.db.WeatherDataBase
import com.app.weatherapp.db.dao.BookmarkPlaceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

class DbModule {

    @Module
    @InstallIn(SingletonComponent::class)
    class DataBaseModule {
        @Provides
        fun providesWeatherDatabase(application: Application): WeatherDataBase {
            return Room.databaseBuilder(
                application.applicationContext,
                WeatherDataBase::class.java,
                "weather_db"
            ).setJournalMode(RoomDatabase.JournalMode.AUTOMATIC).fallbackToDestructiveMigration()
                .build()
        }

        @Provides
        @Singleton
        fun providesAccidentDescCategoryDao(weatherDataBase: WeatherDataBase): BookmarkPlaceDao {
            return weatherDataBase.bookmarkPlaceDao()
        }
    }
}
