package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun findMin(nums: IntArray): Int {
    var l = 0
    var r = nums.lastIndex
    if (nums[l] < nums[r]) return nums[l]
    while (r - l > 1) {
        val m = l + (r - l) / 2
        if (nums[l] > nums[m]) r = m else l = m
    }
    return nums[r]
}