package com.example.smartummah.service.repository

import com.azan.Azan
import com.azan.Method
import com.azan.astrologicalCalc.Location
import com.azan.astrologicalCalc.SimpleDate
import com.example.smartummah.model.Prayer
import com.example.smartummah.utils.StringUtils
import java.util.*

class DataSourceRepository {
    companion object {
        fun fetchPrayerTimes () : List<Prayer> {
            val today = SimpleDate(GregorianCalendar())
            val location = Location(23.8198, 90.3659, 6.0, 0)
            val azan = Azan(location, Method.MUSLIM_LEAGUE)
            val prayerTimes = azan.getPrayerTimes(today)

             var prayerList: ArrayList<Prayer> = ArrayList()

            val fazr = Prayer("Fazr", StringUtils.timeToString(prayerTimes.fajr()))
            prayerList.add(fazr)

            val zuhr = Prayer("Zuhr", StringUtils.timeToString(prayerTimes.thuhr()))
            prayerList.add(zuhr)

            val asr = Prayer("Asr", StringUtils.timeToString(prayerTimes.assr()))
            prayerList.add(asr)

            var magrib = Prayer("Magrib", StringUtils.timeToString(prayerTimes.assr()))
            prayerList.add(magrib)

            var esha = Prayer("Esha", StringUtils.timeToString(prayerTimes.ishaa()))
            prayerList.add(esha)

            var sunrise = Prayer("Sunrise", StringUtils.timeToString(prayerTimes.shuruq()))
            prayerList.add(sunrise)

            return prayerList
        }
    }
}