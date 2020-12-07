package com.app.weatherapp.ui.city

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.app.weatherapp.R
import com.app.weatherapp.databinding.FragmentWeatherBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class WeatherFragment : Fragment() {
    private val cityViewModel: CityViewModel by viewModels()

    private val args: WeatherFragmentArgs by navArgs()

    private lateinit var mBinding: FragmentWeatherBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_weather, container, false)
        mBinding.cityViewModel = cityViewModel

        with(args.bookmarkPlace) {
            loadWeatherData(lat, log)
        }

        mBinding.lifecycleOwner = this

        return mBinding.root

    }

    private fun loadWeatherData(lat: Double, log: Double) {
        lifecycleScope.launch {
            cityViewModel.getForCase(lat.toString(), log.toString())
        }
    }
}