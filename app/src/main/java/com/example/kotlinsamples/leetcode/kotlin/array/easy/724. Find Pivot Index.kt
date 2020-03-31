package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun pivotIndex(nums: IntArray): Int {
    var sum = nums.sum()
    var lsum = 0
    for (i in 0..nums.lastIndex) {
        if (lsum == sum - lsum - nums[i]) return i
        lsum += nums[i]
    }
    return -1
}