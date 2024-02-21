package com.example.smartummah.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartummah.model.Prayer
import com.example.smartummah.model.PrayerTimes
import com.example.smartummah.service.repository.DataSourceRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(private val repository: DataSourceRepository) : ViewModel() {
    private var prayerList: MutableLiveData<List<Prayer>> = MutableLiveData()

    val prayerTimesLiveData: LiveData<PrayerTimes>
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