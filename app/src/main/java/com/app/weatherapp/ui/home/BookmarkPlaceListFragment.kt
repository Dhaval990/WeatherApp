package com.app.weatherapp.ui.home

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.app.weatherapp.R
import com.app.weatherapp.databinding.FragmentBookmarkPlaceBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class BookmarkPlaceListFragment : Fragment() {
    private val bookmarkViewModel: BookmarkViewModel by viewModels()

    private lateinit var mBinding: FragmentBookmarkPlaceBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_bookmark_place,
            container,
            false
        )
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        mBinding.fabAddCity.setOnClickListener {
            BookmarkPlaceListFragmentDirections.actionNavigationHomeToMapsFragment3().let {
                findNavController().navigate(it)
            }


        }


        val placeAdapter = PlaceListAdapter { view, bookmarkPlace ->
            if (view.id == R.id.iv_delete) {
                lifecycleScope.launch {
                    bookmarkViewModel.deletePlace(bookmarkPlace)
                }

            } else {
                BookmarkPlaceListFragmentDirections.actionNavigationHomeToNavigationWeather(
                    bookmarkPlace
                )
                    .let {
                        findNavController().navigate(it)
                    }
            }
        }
        mBinding.rcvPlaceList.adapter = placeAdapter

        bookmarkViewModel.bookmarkPlaceList.observe(
            viewLifecycleOwner, {
                placeAdapter.submitList(it)
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        activity?.menuInflater?.inflate(R.menu.menu_setting, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        BookmarkPlaceListFragmentDirections.actionNavigationHomeToSettingsFragment()
            .let { findNavController().navigate(it) }
        return super.onOptionsItemSelected(item)
    }

}