package com.example.kotlinsamples.leetcode.kotlin.sort

private fun canAttendMeetings(intervals: Array<IntArray>): Boolean { // here we do a sort with a lambda
    intervals.sortWith(kotlin.Comparator { t1, t2 -> t1[1] - t2[1] })
    for (i in 0 until intervals.size - 2) {
        if (intervals[i][1] > intervals[i + 1][0]) return false
    }
    return true
}