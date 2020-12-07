package com.app.weatherapp.ui.city

import com.app.weatherapp.db.network.WeatherApi
import com.app.weatherapp.utils.Extensions
import com.app.weatherapp.utils.Try
import javax.inject.Inject

class CityRepo @Inject constructor(private val weatherApi: WeatherApi) {

    suspend fun getFiveDayForecast(
        lat: String,
        lon: String,
        units: String,
        appID: String,
    ): Try<WeatherData> {
        return Extensions.handleRequestNew {
            weatherApi.getCasePartiesInfoBy(
                lat,
                lon,
                units,
                appID
            )
        }
    }
}