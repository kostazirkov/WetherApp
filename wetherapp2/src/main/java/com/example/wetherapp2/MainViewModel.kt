package com.example.wetherapp2

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.wetherapp2.adapters.WeatherModel

class MainViewModel : ViewModel() {
    val liveDataCurrent = MutableLiveData<WeatherModel>()
    val liveDataList = MutableLiveData<List<WeatherModel>>()
}