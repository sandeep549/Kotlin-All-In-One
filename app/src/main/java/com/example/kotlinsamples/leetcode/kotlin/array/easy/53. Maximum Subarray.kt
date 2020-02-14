package com.example.kotlinsamples.leetcode.kotlin.array.easy

import kotlin.math.max

fun main() {
    println(maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray(intArrayOf(-2, -3, -1, -5)))
    println(maxSubArray(intArrayOf(2, 3, 1, 5)))
    println(maxSubArray(IntArray(0)))
    println()
    println(maxSubArray2(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    println(maxSubArray2(intArrayOf(-2, -3, -1, -5)))
    println(maxSubArray2(intArrayOf(2, 3, 1, 5)))
    println(maxSubArray2(IntArray(0)))
}

private fun maxSubArray(nums: IntArray): Int {
    if (nums.size == 0) return 0
    var maxendinghere = nums[0]
    var maxsofar = nums[0]
    for (i in 1..nums.lastIndex) {
        maxendinghere = max(nums[i], maxendinghere + nums[i])
        maxsofar = max(maxsofar, maxendinghere)
    }
    return maxsofar
}

private fun maxSubArray2(nums: IntArray): Int {
    if (nums.size == 0) return 0
    var ans = Int.MIN_VALUE
    for (s in 0..nums.lastIndex) {
        var maxendinghere = nums[s]
        var maxsofar = nums[s]
        for (e in s + 1..nums.lastIndex) {
            maxendinghere = max(nums[e], maxendinghere + nums[e])
            maxsofar = max(maxsofar, maxendinghere)
        }
        ans = max(ans, maxsofar)
    }
    return ans
}