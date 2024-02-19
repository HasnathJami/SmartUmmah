package com.example.smartummah.di.component

import com.example.smartummah.di.module.NetworkModule
import com.example.smartummah.di.qualifier.MyRetrofit1
import com.example.smartummah.service.network.ApiInterface
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    //Expose Methods

    @Named("myApiInterface2")
    fun providesApiInterface(): ApiInterface

    @MyRetrofit1
    fun providesApiInterface2(): ApiInterface

 //   fun providesApiInterface2(): ApiInterface
}