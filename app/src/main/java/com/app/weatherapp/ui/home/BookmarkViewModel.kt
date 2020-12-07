package com.app.weatherapp.ui.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import androidx.paging.toLiveData
import com.app.weatherapp.db.entites.BookmarkPlace


class BookmarkViewModel @ViewModelInject constructor(
    private val bookmarkPlaceRepo: BookmarkPlaceRepo,

    ) : ViewModel() {
    suspend fun deletePlace(bookmarkPlace: BookmarkPlace) {
        bookmarkPlaceRepo.deletePlace(bookmarkPlace)
    }

    val bookmarkPlaceList: LiveData<PagedList<BookmarkPlace>> =
        bookmarkPlaceRepo.getAllBookmarkPlaces().toLiveData(pageSize = 10)


}