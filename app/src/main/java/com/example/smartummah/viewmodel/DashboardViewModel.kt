package com.example.smartummah.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.azan.Azan
import com.azan.Method
import com.azan.astrologicalCalc.Location
import com.azan.astrologicalCalc.SimpleDate
import com.example.smartummah.model.Prayer
import com.example.smartummah.utils.StringUtils
import java.util.*

class DashboardViewModel(application: Application) : AndroidViewModel(application) {

    private var fazrTime: MutableLiveData<String> = MutableLiveData()
    private var zuhrTime: MutableLiveData<String> = MutableLiveData()
    private var asrTime: MutableLiveData<String> = MutableLiveData()
    private var magribTime: MutableLiveData<String> = MutableLiveData()
    private var ishaTime: MutableLiveData<String> = MutableLiveData()
    private var sunriseTime: MutableLiveData<String> = MutableLiveData()

    private var prayerList: MutableLiveData<List<Prayer>> = MutableLiveData()
    private var list: ArrayList<Prayer> = ArrayList()


    init {
        val today = SimpleDate(GregorianCalendar())
        val location = Location(23.8198, 90.3659, 6.0, 0)
        val azan = Azan(location, Method.MUSLIM_LEAGUE)
        val prayerTimes = azan.getPrayerTimes(today)
        //fazrTime.value = StringUtils.convert12HourFormat(StringUtils.timeToString(prayerTimes.fajr()));
        fazrTime.value = StringUtils.timeToString(prayerTimes.fajr());
        zuhrTime.value = StringUtils.timeToString(prayerTimes.thuhr());
        asrTime.value = StringUtils.timeToString(prayerTimes.assr());
        magribTime.value = StringUtils.timeToString(prayerTimes.maghrib());
        ishaTime.value = StringUtils.timeToString(prayerTimes.ishaa());
        sunriseTime.value = StringUtils.timeToString(prayerTimes.shuruq());

//        list.add(Prayer("Fazr", fazrTime.value))
//        list.add(Prayer("Zuhr", zuhrTime.value))
//        list.add(Prayer("Asr", asrTime.value))
//        list.add(Prayer("Magrib", magribTime.value))
//        list.add(Prayer("Esha", ishaTime.value))
//        list.add(Prayer("Sunrise", sunriseTime.value))


        val res1 = Prayer("", "").apply {
            prayerName = "Fazr"
            prayerTime = fazrTime.value
        }
        list.add(res1)

        val res2 = Prayer("", "").apply {
            prayerName = "Zuhr"
            prayerTime = zuhrTime.value
        }
        list.add(res2)

        val res3 = Prayer("Asr", asrTime.value).apply {}
        list.add(res3)

        var res4 = Prayer("", "").also { prayer ->
            prayer.prayerName = "Magrib"
            prayer.prayerTime = magribTime.value
        }
        list.add(res4)

        var res5 = Prayer("", "").also { prayer ->
            prayer.prayerName = "Esha"
            prayer.prayerTime = ishaTime.value
        }
        list.add(res5)

        var res66 = Prayer("Sunrise", sunriseTime.value).also {
            //prayer -> prayer.prayerName = prayer.prayerName.uppercase()
        }
        list.add(res66)

//         Return Unit
//        val res7 = Prayer("","").let { prayer ->
//            prayer.prayerName = "Asr"
//            prayer.prayerTime = asrTime.value
//        }
//        list.add(res7)

        // Return Unit
//        val res8 = Prayer("","").run {
//            prayerName = "Esha"
//            prayerTime = ishaTime.value
//        }
//        list.add(res8)

        // Return Unit
//        var res9 = with(Prayer("","")) {
//            prayerName = "Sunrise"
//            prayerTime = sunriseTime.value
//        }
//        list.add(res9)

        prayerList.value = list
    }

    val prayerListExtract: MutableLiveData<List<Prayer>> get() = prayerList

//    fun getFazrTime(): LiveData<String> {
//        return fazrTime
//    }
//
//    fun getZuhrTime(): LiveData<String> {
//        return zuhrTime
//    }
//
//    fun getAsrTime(): LiveData<String> {
//        return asrTime
//    }
//
//    fun getMagribTime(): LiveData<String> {
//        return magribTime
//    }
//
//    fun getIshaTime(): LiveData<String> {
//        return ishaTime
//    }
//
//    fun getSunriseTime(): LiveData<String> {
//        return sunriseTime
//    }

//    fun getPrayerList() : LiveData<List<Prayer>>{
//        return prayerList
//    }


}