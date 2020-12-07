package com.app.weatherapp.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import androidx.preference.PreferenceManager
import javax.inject.Singleton

@Singleton
class AppPreferences(context: Context) {

    companion object {
        const val API_TOKEN = "app_token"
        const val UNIT = "UNIT"
    }

    private var prefs: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)


    fun getAppToken(): String {

        return prefs.getString(API_TOKEN, "fae7190d7e6433ec3a45285ffcf55c86").toString()
    }

    fun setUnit(unit: String) {
        prefs.edit(commit = false) { putString(UNIT, unit) }
    }

    fun getUnit(): String {
        return prefs.getString(UNIT, "metric").toString()
    }

}
