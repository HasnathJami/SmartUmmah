package com.example.smartummah.utils

class StringUtils {
    companion object {

        lateinit var time: String

        fun <T> timeToString(time: T): String {
            return time.toString()
        }

//        fun convert12HourFormat(str: String) : String {
//            val h1 = str[0].toInt() - '0'.toInt()
//            val h2 = str[1].toInt() - '0'.toInt()
//            var hh = h1 * 10 + h2
//
//            // Finding out the Meridien of time
//            // ie. AM or PM
//            val Meridien: String = if (hh < 12) {
//                "AM"
//            } else "PM"
//            hh %= 12
//
//            // Handle 00 and 12 case separately
//            if (hh == 0) {
//                time += "12"
//                //print("12")
//
//                // Printing minutes and seconds
//                for (i in 2..7) {
//                    //print(str[i])
//                    time += str[i]
//                }
//            } else {
//                //print(hh)
//                time += hh
//                // Printing minutes and seconds
//                for (i in 2..7) {
//                    //print(str[i])
//                    time += str[i]
//                }
//            }
//
//            // After time is printed
//            // cout Meridien
//            //println(" $Meridien")
//            time += " $Meridien"
//
//           return time
//        }

    }
}