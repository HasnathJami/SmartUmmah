package com.example.smartummah.di.component

import androidx.fragment.app.Fragment
import com.example.smartummah.di.scope.FragmentScope
import com.example.smartummah.service.network.ApiInterface
import com.example.smartummah.view.ui.fragment.dashboard.DashboardFragment
import dagger.Component
@FragmentScope
@Component(dependencies = [AppComponent::class])
interface FragmentComponent {
    fun inject(fragment: DashboardFragment)
}