package com.app.weatherapp.utils;

import android.view.View;

@FunctionalInterface
public interface SetOnItemListener {
    void onItemClick(View view, Object o, int position);
}
