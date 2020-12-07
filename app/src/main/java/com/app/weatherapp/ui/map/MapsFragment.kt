package com.app.weatherapp.ui.map

import android.content.Context
import android.location.Address
import android.location.Geocoder
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.app.weatherapp.R
import com.app.weatherapp.db.entites.BookmarkPlace
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import java.util.*


@AndroidEntryPoint
class MapsFragment : androidx.fragment.app.Fragment() {
    private var mGoogleMap: GoogleMap? = null

    private val mapViewModel: MapViewModel by viewModels()

    private val callback = OnMapReadyCallback { googleMap ->
        mGoogleMap = googleMap
        setupListener()
    }

    private fun setupListener() {
        mGoogleMap?.setOnMapClickListener { latLng ->
            mGoogleMap?.addMarker(
                MarkerOptions()
                    .position(latLng)
            )


            lifecycleScope.launch {
                getCityNameFromLocation(requireContext(), latLng)?.let { cityName ->
                    mapViewModel.addBookmarkPlace(
                        BookmarkPlace(
                            0,
                            latLng.latitude,
                            latLng.longitude,
                            cityName
                        )
                    ) {
                        if (it > 0) {
                            Toast.makeText(
                                requireContext(),
                                "Place set as a bookmark",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
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


    private fun getCityNameFromLocation(
        context: Context,
        latLng: LatLng
    ): String? {

        val addresses: List<Address> =
            Geocoder(context, Locale.ENGLISH).getFromLocation(latLng.latitude, latLng.longitude, 1)
        return if (addresses.isNotEmpty()) {
            val fetchedAddress: Address = addresses[0]
            fetchedAddress.locality

        } else {
            null
        }

    }

}