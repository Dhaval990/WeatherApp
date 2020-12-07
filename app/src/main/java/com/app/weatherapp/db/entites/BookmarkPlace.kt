package com.app.weatherapp.db.entites

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "bookmark_place")
data class BookmarkPlace(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val lat: Double,
    val log: Double,
    val cityName: String
) : Parcelable {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BookmarkPlace>() {
            // The ID property identifies when items are the same.
            override fun areItemsTheSame(oldItem: BookmarkPlace, newItem: BookmarkPlace) =
                oldItem.id == newItem.id

            // If you use the "==" operator, make sure that the object implements
            // .equals(). Alternatively, write custom data comparison logic here.
            override fun areContentsTheSame(
                oldItem: BookmarkPlace, newItem: BookmarkPlace
            ) = oldItem == newItem
        }
    }
}
