package com.example.smartummah.di.component

import com.example.smartummah.di.module.NetworkModule
import com.example.smartummah.view.ui.fragment.dashboard.DashboardFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(fragment: DashboardFragment)
}