package com.app.weatherapp.ui.map

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.app.weatherapp.R
import com.app.weatherapp.db.entites.BookmarkPlace
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MapsFragment : androidx.fragment.app.Fragment() {
    private var mGoogleMap: GoogleMap? = null

    private val mapViewModel: MapViewModel by viewModels()

    private val callback = OnMapReadyCallback { googleMap ->
        mGoogleMap = googleMap
        setupListener()
    }

    private fun setupListener() {
        mGoogleMap?.setOnMapClickListener {
            mGoogleMap?.addMarker(
                MarkerOptions()
                    .position(it)
            )


            lifecycleScope.launch {
                mapViewModel.addBookmarkPlace(BookmarkPlace(0, it.latitude, it.longitude))
            }

        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(callback)


    }


}