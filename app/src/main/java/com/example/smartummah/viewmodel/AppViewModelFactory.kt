package com.example.smartummah.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.smartummah.service.repository.DataSourceRepository
import javax.inject.Inject

class AppViewModelFactory @Inject constructor(private val repository: DataSourceRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return DashboardViewModel(repository = repository) as T
    }
}