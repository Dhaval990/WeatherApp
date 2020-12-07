package com.app.weatherapp.ui.city

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.app.weatherapp.utils.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CityViewModel @ViewModelInject constructor(
    private val cityRepo: CityRepo,
    private val appPreferences: AppPreferences
) : ViewModel() {

    private val _weatherData = MutableLiveData<WeatherData>()
    val weatherData: LiveData<WeatherData>
        get() = _weatherData


    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean>
        get() = _isLoading


    suspend fun getForCase(
        lat: String,
        lon: String,
        units: String,
        appID: String = appPreferences.getAppToken(),
    ) {
        withContext(Dispatchers.IO) {
            _isLoading.postValue(true)
            with(cityRepo.getFiveDayForecast(lat, lon, units, appID)) {
                if (isSuccess) {
                    getOrNull()?.let {
                        _weatherData.postValue(it)
                    }
                }
                _isLoading.postValue(false)
            }
        }
    }
}