package com.example.smartummah.di

import com.example.smartummah.view.ui.DashboardFragment
import dagger.Component

@Component(modules = [AppModule::class])
interface AppComponent {
    fun inject(fragment: DashboardFragment)
}