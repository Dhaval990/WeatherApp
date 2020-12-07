package com.app.weatherapp.ui.setting

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.app.weatherapp.R

class SettingsFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.root_preferences, rootKey)
    }
}