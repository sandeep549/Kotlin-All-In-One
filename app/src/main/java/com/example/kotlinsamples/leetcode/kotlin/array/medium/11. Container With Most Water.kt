package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun maxArea(height: IntArray): Int {
    var max = 0
    var l = 0
    var r = height.lastIndex
    while (l < r) {
        var curr = (r - l) * minOf(height[l], height[r])
        max = maxOf(max, curr)
        if (height[l] <= height[r]) l++
        else r--
    }
    return max
}