package com.app.weatherapp.utils

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import androidx.core.content.edit
import com.app.weatherapp.R
import javax.inject.Singleton

@Singleton
class AppPreferences(context: Context) {

    companion object {
        const val API_TOKEN = "app_token"

    }

    private var prefs: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.app_name),
        MODE_PRIVATE
    )

    fun setAppToken(token: String) {
        prefs.edit(commit = true) { putString(API_TOKEN, token) }
    }

    fun getAppToken(): String {
        return prefs.getString(API_TOKEN, "").toString()
    }

}
