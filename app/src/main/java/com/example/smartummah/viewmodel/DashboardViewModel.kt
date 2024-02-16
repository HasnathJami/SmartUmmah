package com.example.smartummah.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.smartummah.model.Prayer
import com.example.smartummah.service.repository.DataSourceRepository

class DashboardViewModel(application: Application) : AndroidViewModel(application) {
    private var prayerList: MutableLiveData<List<Prayer>> = MutableLiveData()

    init {
        prayerList.value = DataSourceRepository.fetchPrayerTimes()
    }

    //val prayerListExtract: LiveData<List<Prayer>> get() = prayerList
    fun fetchPrayerList() = prayerList

}