package com.example.kotlinsamples.leetcode.kotlin.hashtable

private fun firstUniqChar(s: String): Int {
    var seen = s.toCharArray().groupBy { it }.mapValues { it.value.size }
    for (i in s.indices) {
        if (seen.get(s[i]) == 1) return i
    }
    return -1
}