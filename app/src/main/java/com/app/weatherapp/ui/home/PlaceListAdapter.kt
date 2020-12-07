package com.app.weatherapp.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.app.weatherapp.R
import com.app.weatherapp.databinding.RawPlaceBinding
import com.app.weatherapp.db.entites.BookmarkPlace
import com.app.weatherapp.db.entites.BookmarkPlace.Companion.DIFF_CALLBACK
import com.app.weatherapp.ui.home.PlaceListAdapter.PlaceViewHolder

class PlaceListAdapter(private val onItemListener: SetOnItemListener) :
    PagedListAdapter<BookmarkPlace, PlaceViewHolder>(DIFF_CALLBACK) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlaceViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.raw_place, parent, false)
        return PlaceViewHolder(v)
    }

    override fun onBindViewHolder(holder: PlaceViewHolder, position: Int) {
        val bookmarkPlace = getItem(position)
        if (bookmarkPlace != null) {
            holder.bindTo(bookmarkPlace)
        }

    }

    inner class PlaceViewHolder(itemView: View) :
        RecyclerView.ViewHolder(
            itemView
        ) {
        private val rawPlaceBinding: RawPlaceBinding? = DataBindingUtil.bind(itemView)
        fun bindTo(bookmarkPlace: BookmarkPlace) {
            rawPlaceBinding?.bookmarkPlace = bookmarkPlace

        }

        init {
            rawPlaceBinding?.tvPlace?.setOnClickListener {
                currentList?.get(adapterPosition)
                    ?.let { it1 -> onItemListener.onItemClick(it, it1) }
            }
            rawPlaceBinding?.ivDelete?.setOnClickListener {
                currentList?.get(adapterPosition)
                    ?.let { it1 -> onItemListener.onItemClick(it, it1) }
            }
        }
    }

    fun interface SetOnItemListener {
        fun onItemClick(view: View, bookmarkPlace: BookmarkPlace)
    }

}
