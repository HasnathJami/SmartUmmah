package com.example.smartummah.service.network

import com.example.smartummah.model.PrayerTimes
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {
    @GET("v1/timingsByCity/{date}")
    suspend fun fetchPrayerTimes(
        @Path("date") date:String,
        @Query("city") city: String,
        @Query("country") country: String,
        @Query("method") method: Int
    ) : Response<PrayerTimes>
}