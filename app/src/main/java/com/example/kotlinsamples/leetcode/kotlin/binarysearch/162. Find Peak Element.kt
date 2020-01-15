package com.example.kotlinsamples.leetcode.kotlin.binarysearch

fun main() {
    println(findPeakElement(intArrayOf(1, 2, 3, 1)))
    println(findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4)))
    println(findPeakElement(intArrayOf(1, 2)))
}

private fun findPeakElement(arr: IntArray): Int {
    var l = 0
    var r = arr.lastIndex
    while (l < r) {
        var m = l + (r - l) / 2
        if (arr[m] < arr[m + 1]) l = m + 1
        else r = m
    }
    return l
}
