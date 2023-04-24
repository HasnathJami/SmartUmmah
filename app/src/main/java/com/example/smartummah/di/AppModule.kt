package com.example.smartummah.di

import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context:Context){

    @Provides
    fun providesContext(): Context = context
}