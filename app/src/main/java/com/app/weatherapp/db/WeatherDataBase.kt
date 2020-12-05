package com.app.weatherapp.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.weatherapp.db.dao.BookmarkPlaceDao
import com.app.weatherapp.db.entites.BookmarkPlace


@Database(
    entities = [
        BookmarkPlace::class
    ], exportSchema = false, version = 1
)
abstract class WeatherDataBase : RoomDatabase() {

    abstract fun bookmarkPlaceDao(): BookmarkPlaceDao
}
