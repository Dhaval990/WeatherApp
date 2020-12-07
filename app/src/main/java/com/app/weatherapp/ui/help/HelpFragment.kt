package com.app.weatherapp.ui.help

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.app.weatherapp.R
import com.app.weatherapp.databinding.FragmentHelpBinding

class HelpFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding: FragmentHelpBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_help, container, false)


        binding.webview.loadData(getString(R.string.help), "text/html", "UTF-8")

        return binding.root
    }
}