package com.example.smartummah.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class DashboardViewModel(application: Application) : AndroidViewModel(application) {
    private var name: MutableLiveData<String> = MutableLiveData()

    fun setName(name: String) {
        this.name.value = name
    }

    fun getName(): LiveData<String> {
        return name
    }

}