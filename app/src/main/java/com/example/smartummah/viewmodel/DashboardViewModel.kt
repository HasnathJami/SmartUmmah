package com.example.smartummah.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.example.smartummah.model.Prayer
import com.example.smartummah.model.PrayerTimes
import com.example.smartummah.service.repository.DataSourceRepository
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: DataSourceRepository) :ViewModel() {
    private var prayerList: MutableLiveData<List<Prayer>> = MutableLiveData()

    val prayerTimesLiveData : LiveData<PrayerTimes>
        get() = repository.prayerTimes

    init {
        prayerList.value = repository.fetchPrayerTimes()
        viewModelScope.launch {
            repository.getPrayerTimesFromApi()
        }
    }

    //val prayerListExtract: LiveData<List<Prayer>> get() = prayerList
    fun fetchPrayerList() = prayerList

}