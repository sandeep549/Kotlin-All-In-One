package com.example.kotlinsamples.leetcode.kotlin.array.easy

import android.annotation.SuppressLint
import java.util.*

@SuppressLint("NewApi")
private fun minMeetingRooms(intervals: Array<IntArray>): Int {
    intervals.sortBy { it[0] }
    var pq = PriorityQueue<IntArray>() { a1, a2 -> a1[1] - a2[1] } // sort by end time
    for (meeting in intervals) {
        if (!pq.isEmpty() && pq.peek()[1] <= meeting[0]) pq.poll() // notice equal, we are not counting swapping time
        pq.add(meeting)
    }
    return pq.size
}

// todo check below solution
// https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-@pinkfloyda
