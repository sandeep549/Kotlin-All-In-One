package com.example.kotlinsamples.leetcode.kotlin.binarysearch

fun firstBadVersion(n: Int): Int {
    var l = 1
    var r = n
    var mid = 0
    while (l < r) {
        mid = l + (r - l) / 2
        if (!isBadVersion(mid)) l = mid + 1 else r = mid
    }
    return l
}

fun isBadVersion(mid: Int): Boolean {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
}
