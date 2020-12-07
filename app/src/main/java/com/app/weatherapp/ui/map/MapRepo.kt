package com.app.weatherapp.ui.map

import com.app.weatherapp.db.dao.BookmarkPlaceDao
import com.app.weatherapp.db.entites.BookmarkPlace
import javax.inject.Inject

class MapRepo @Inject constructor(
    private val bookmarkPlaceDao: BookmarkPlaceDao
) {

    suspend fun addBookmarkPlace(bookmarkPlace: BookmarkPlace) =
        bookmarkPlaceDao.addPlace(bookmarkPlace)


}