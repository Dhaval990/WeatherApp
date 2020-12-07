package com.app.weatherapp.ui.home

import com.app.weatherapp.db.dao.BookmarkPlaceDao
import com.app.weatherapp.db.entites.BookmarkPlace
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class BookmarkPlaceRepo @Inject constructor(
    private val bookmarkPlaceDao: BookmarkPlaceDao,
) {
    fun getAllBookmarkPlaces() = bookmarkPlaceDao.getAllPlaces()
    suspend fun deletePlace(bookmarkPlace: BookmarkPlace) {
        withContext(Dispatchers.IO) {
            bookmarkPlaceDao.deleteBookmarkPlace(bookmarkPlace)

        }
    }
}