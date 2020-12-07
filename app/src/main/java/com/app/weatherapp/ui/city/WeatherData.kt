package com.app.weatherapp.ui.city

import com.google.gson.annotations.SerializedName

data class WeatherData(

	var unit: String? = null,

	@SerializedName("rain")
	val rain: Rain? = null,

	@SerializedName("visibility")
	val visibility: Int? = null,

	@SerializedName("timezone")
	val timezone: Int? = null,

	@SerializedName("main")
	val main: Main? = null,

	@SerializedName("clouds")
	val clouds: Clouds? = null,

	@SerializedName("sys")
	val sys: Sys? = null,

	@SerializedName("dt")
	val dt: Int? = null,

	@SerializedName("coord")
	val coord: Coord? = null,

	@SerializedName("weather")
	val weather: List<WeatherItem?>? = null,

	@SerializedName("name")
	val name: String? = null,

	@SerializedName("cod")
	val cod: Int? = null,

	@SerializedName("id")
	val id: Int? = null,

	@SerializedName("base")
	val base: String? = null,

	@SerializedName("wind")
	val wind: Wind? = null
)

data class WeatherItem(

	@SerializedName("icon")
	val icon: String? = null,

	@SerializedName("description")
	val description: String? = null,

	@SerializedName("main")
	val main: String? = null,

	@SerializedName("id")
	val id: Int? = null
)

data class Clouds(

	@SerializedName("all")
	val all: Int? = null
)

data class Wind(

	@SerializedName("deg")
	val deg: Int? = null,

	@SerializedName("speed")
	val speed: Double? = null
)

data class Sys(

	@SerializedName("sunrise")
	val sunrise: Int? = null,

	@SerializedName("sunset")
	val sunset: Int? = null
)

data class Main(

	@SerializedName("temp")
	val temp: Double? = null,

	@SerializedName("temp_min")
	val tempMin: Double? = null,

	@SerializedName("grnd_level")
	val grndLevel: Int? = null,

	@SerializedName("humidity")
	val humidity: Int? = null,

	@SerializedName("pressure")
	val pressure: Int? = null,

	@SerializedName("sea_level")
	val seaLevel: Int? = null,

	@SerializedName("feels_like")
	val feelsLike: Double? = null,

	@SerializedName("temp_max")
	val tempMax: Double? = null
)

data class Coord(

	@SerializedName("lon")
	val lon: Double? = null,

	@SerializedName("lat")
	val lat: Double? = null
)

data class Rain(
	@SerializedName("1h")
	val jsonMember1h: Double? = null
)
