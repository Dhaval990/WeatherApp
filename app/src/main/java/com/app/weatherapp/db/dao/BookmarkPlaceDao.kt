package com.app.weatherapp.db.dao

import androidx.room.Dao
import androidx.room.Insert
import com.app.weatherapp.db.entites.BookmarkPlace

@Dao
interface BookmarkPlaceDao {
    @Insert
    suspend fun addPlace(bookmarkPlace: BookmarkPlace)
}
