package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun numOfSubarrays(arr: IntArray, k: Int, threshold: Int): Int {
    var count = 0
    var sum = 0
    var i = 0
    while (i < k - 1) sum += arr[i++]
    for (j in i..arr.lastIndex) {
        sum += arr[j]
        if (sum / k >= threshold) count++
        sum -= arr[j - k + 1]
    }
    return count
}