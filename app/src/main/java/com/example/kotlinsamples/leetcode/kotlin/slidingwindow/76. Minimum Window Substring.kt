package com.example.kotlinsamples.leetcode.kotlin.slidingwindow

import android.annotation.SuppressLint

@SuppressLint("NewApi")
private fun minWindow(s: String, t: String): String {
    if (s.length < t.length) return ""
    val dict = t.toCharArray().groupBy { it }.mapValues { it.value.size }.toMutableMap()
    val required = dict.size
    var l = 0
    var r = 0
    var formed = 0
    val windowCounts: MutableMap<Char, Int> = HashMap()
    var ans = Pair(0, s.length + 1)
    while (r < s.length) { // Add one character from the right to the window
        var c = s[r]
        windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1)
        if (dict.containsKey(c) && windowCounts[c]!! == dict[c]!!) {
            formed++
        }
        while (l <= r && formed == required) {
            c = s[l]
            ans = Pair(l, r) // save new smallest window
            windowCounts[c] = windowCounts[c]!! - 1
            if (dict.containsKey(c) && windowCounts[c]!! < dict[c]!!) {
                formed--
            }
            l++
        }
        r++
    }
    return if (ans.second - ans.first > s.length) "" else s.substring(ans.first, ans.second + 1)
}

private fun minWindow2(s: String, t: String): String {
    val map = t.toCharArray().groupBy { it }.mapValues { it.value.size }.toMutableMap()
    var start = 0
    var end = 0
    var minStart = 0
    var minLen = Int.MAX_VALUE
    var counter = t.length

    while (end < s.length) {
        val c1 = s[end]
        if (map.contains(c1)) {
            if (map[c1]!! > 0) counter--
            map[c1] = map[c1]!! - 1
        }
        end++

        while (counter == 0) {
            if (minLen > end - start) {
                minLen = end - start
                minStart = start
            }
            val c2 = s[start]
            if (map.contains(c2)) {
                map[c2] = map[c2]!! + 1
                if (map[c2]!! > 0) counter++
            }
            start++
        }
    }
    return if (minLen == Int.MAX_VALUE) "" else s.substring(minStart, minStart + minLen)
}
