package com.app.weatherapp.db.entites

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmark_place")
data class BookmarkPlace(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val lat: Double,
    val log: Double,
    val cityName: String
)
