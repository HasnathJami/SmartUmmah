package com.example.smartummah.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.azan.Azan
import com.azan.Method
import com.azan.astrologicalCalc.Location
import com.azan.astrologicalCalc.SimpleDate
import com.example.smartummah.utils.StringUtils
import java.util.*

class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    private var fazrTime: MutableLiveData<String> = MutableLiveData()
    private var zuhrTime: MutableLiveData<String> = MutableLiveData()
    private var asrTime: MutableLiveData<String> = MutableLiveData()
    private var magribTime: MutableLiveData<String> = MutableLiveData()
    private var ishaTime: MutableLiveData<String> = MutableLiveData()
    private var sunriseTime: MutableLiveData<String> = MutableLiveData()

    init {
        val today = SimpleDate(GregorianCalendar())
        val location = Location(23.8198, 90.3659, 6.0, 0)
        val azan = Azan(location, Method.MUSLIM_LEAGUE)
        val prayerTimes = azan.getPrayerTimes(today)
        fazrTime.value = StringUtils.timeToString(prayerTimes.fajr());
        zuhrTime.value = StringUtils.timeToString(prayerTimes.thuhr());
        asrTime.value = StringUtils.timeToString(prayerTimes.assr());
        magribTime.value = StringUtils.timeToString(prayerTimes.maghrib());
        ishaTime.value = StringUtils.timeToString(prayerTimes.ishaa());
        sunriseTime.value = StringUtils.timeToString(prayerTimes.shuruq());

    }


    fun getFazrTime(): LiveData<String> {
        return fazrTime
    }

    fun getZuhrTime(): LiveData<String> {
        return zuhrTime
    }

    fun getAsrTime(): LiveData<String> {
        return asrTime
    }

    fun getMagribTime(): LiveData<String> {
        return magribTime
    }

    fun getIshaTime(): LiveData<String> {
        return ishaTime
    }

    fun getSunriseTime(): LiveData<String> {
        return sunriseTime
    }

}