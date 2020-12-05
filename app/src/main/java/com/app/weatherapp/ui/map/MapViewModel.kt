package com.app.weatherapp.ui.map

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.app.weatherapp.db.entites.BookmarkPlace
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MapViewModel @ViewModelInject constructor(
    private val mapRepo: MapRepo
) : ViewModel() {


    suspend fun addBookmarkPlace(bookmarkPlace: BookmarkPlace) {
        withContext(Dispatchers.IO)
        {
            mapRepo.addBookmarkPlace(bookmarkPlace)
        }
    }
}