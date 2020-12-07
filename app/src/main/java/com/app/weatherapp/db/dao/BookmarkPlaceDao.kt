package com.app.weatherapp.db.dao

import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.app.weatherapp.db.entites.BookmarkPlace


@Dao
interface BookmarkPlaceDao {
    @Insert
    suspend fun addPlace(bookmarkPlace: BookmarkPlace): Long


    @Query("SELECT * FROM bookmark_place")
    fun getAllPlaces(): DataSource.Factory<Int, BookmarkPlace>

    @Delete
    suspend fun deleteBookmarkPlace(bookmarkPlace: BookmarkPlace): Int
}
