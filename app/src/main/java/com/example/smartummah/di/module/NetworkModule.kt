package com.example.smartummah.di.module

import com.example.smartummah.di.qualifier.MyRetrofit1
import com.example.smartummah.service.network.ApiInterface
import com.example.smartummah.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder().baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    @Named("myApiInterface2")
    fun providesApiInterface(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }

    @Singleton
    @Provides
    @MyRetrofit1
    fun providesApiInterface2(retrofit: Retrofit): ApiInterface {
        return retrofit.create(ApiInterface::class.java)
    }


//    @Provides
//    @Singleton
//    fun providesApiInterface(retrofit: Retrofit): ApiInterface {
//        return retrofit.create(ApiInterface::class.java)
//    }
}