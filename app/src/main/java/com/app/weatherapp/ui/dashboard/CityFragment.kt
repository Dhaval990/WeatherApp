package com.app.weatherapp.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.app.weatherapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CityFragment : Fragment() {
    private val cityViewModel: CityViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_city, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        cityViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return root
    }
}