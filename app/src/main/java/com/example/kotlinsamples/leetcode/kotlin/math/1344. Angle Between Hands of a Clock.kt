package com.example.kotlinsamples.leetcode.kotlin.math

import kotlin.math.abs

private fun angleClock(hour: Int, minutes: Int): Double {
    var hr = if (hour == 12) 0 else hour
    var hoursNeedle = (5 * hr) + (5.toDouble() / 60) * minutes
    var minuteNeedle = minutes
    var diff = abs(hoursNeedle - minuteNeedle)
    var angle = (360 / 60) * diff
    return if (angle > 180) 360 - angle else angle
}