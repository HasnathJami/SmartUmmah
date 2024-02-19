package com.example.smartummah.application

import android.app.Application
import com.example.smartummah.di.component.AppComponent
import com.example.smartummah.di.component.DaggerAppComponent

class UserApplication : Application() {

    lateinit var applicationComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        //applicationComponent = DaggerAppComponent.builder().networkModule(NetworkModule()).build() // no need this one
        applicationComponent = DaggerAppComponent.builder().build()
       // applicationComponent.inject(this)
    }
}