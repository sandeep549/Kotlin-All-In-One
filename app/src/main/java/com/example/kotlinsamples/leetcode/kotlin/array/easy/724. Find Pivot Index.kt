package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun pivotIndex(nums: IntArray): Int {
    var sum = nums.sum()
    var lsum = 0
    var rsum = sum
    for (i in 0..nums.lastIndex) {
        rsum = sum - lsum - nums[i]
        if (lsum == rsum) return i
        lsum += nums[i]
    }
    return -1
}