package com.example.kotlinsamples.leetcode.kotlin.binarysearch

private fun findInMountainArray(target: Int, mountainArray: MountainArray): Int {
    // cache the calls to minimize calls to MountainArray
    var cache = IntArray(mountainArray.length()) { -1 }
    fun item(index: Int): Int {
        if (cache[index] == -1) cache[index] = mountainArray.get(index)
        return cache[index]
    }

    // find peak
    var l = 0
    var r = mountainArray.length() - 1
    while (l < r) {
        var m = l + (r - l) / 2
        if (item(m) < item(m + 1)) l = m + 1
        else r = m
    }
    var peak = l

    // search in left side to min index
    l = 0
    r = peak
    while (l < r) {
        var m = l + (r - l) / 2
        if (target > item(m)) l = m + 1
        else r = m
    }
    if (target == item(l)) return l

    // search in right half
    l = peak + 1
    r = mountainArray.length() - 1
    while (l < r) {
        var m = l + (r - l) / 2
        if (target < item(m)) l = m + 1
        else r = m
    }
    return if (target == item(l)) return l else -1
}

interface MountainArray {
    fun get(index: Int): Int
    fun length(): Int
}