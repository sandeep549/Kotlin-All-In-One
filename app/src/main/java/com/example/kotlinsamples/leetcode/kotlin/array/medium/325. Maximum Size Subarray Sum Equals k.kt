package com.example.kotlinsamples.leetcode.kotlin.array.medium

import android.annotation.SuppressLint

@SuppressLint("NewApi")
private fun maxSubArrayLen(nums: IntArray, k: Int): Int {
    var max = 0
    var map = mutableMapOf<Int, Int>()
    var sum = 0
    for (i in nums.indices) {
        sum += nums[i]
        if (sum == k) max = i + 1
        map.putIfAbsent(sum, i)
        map.get(sum - k)?.let {
            if (i - it > max) max = i - it
        }
    }
    return max
}