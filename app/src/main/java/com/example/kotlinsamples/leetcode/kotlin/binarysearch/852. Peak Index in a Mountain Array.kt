package com.example.kotlinsamples.leetcode.kotlin.binarysearch

fun main() {
    println(peakIndexInMountainArray(intArrayOf(0, 2, 1, 0)))
}

private fun peakIndexInMountainArray(arr: IntArray): Int {
    var l = 0
    var r = arr.lastIndex
    while (l < r) {
        var m = l + (r - l) / 2
        if (arr[m] < arr[m + 1]) l = m + 1
        else r = m
    }
    return l
}