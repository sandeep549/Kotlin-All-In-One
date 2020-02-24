package com.example.kotlinsamples.leetcode.kotlin.misc

import kotlin.math.abs

private fun daysBetweenDates(date1: String, date2: String): Int {
    fun isleap(year: Int) = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)

    var mdays = intArrayOf(0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365)
    fun days(d: String): Int {
        val ss = d.split("-")
        val year = ss[0].toInt()
        val month = ss[1].toInt()
        val day = ss[2].toInt()
        // years we spent, hence -1 because current year is not spent yet
        val ydelta = year - 1 - 1900
        val dy = ydelta * 365 + ydelta / 4 // from 1900 every 4 years is leap year
        // month-1, current month is not done yet
        var dm = mdays[month - 1]
        if (isleap(year) && month - 1 >= 2) {
            dm++
        }
        return dy + dm + day
    }

    val days1 = days(date1)
    val days2 = days(date2)
    return abs(days1 - days2)
}