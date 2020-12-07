package com.app.weatherapp.db.network

import com.app.weatherapp.ui.city.WeatherData
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherApi {
    @GET("weather")
    suspend fun getCasePartiesInfoBy(
        @Query("lat") lat: String,
        @Query("lon") lon: String,
        @Query("units") units: String,
        @Query("appid") appID: String,
    ): WeatherData

}
