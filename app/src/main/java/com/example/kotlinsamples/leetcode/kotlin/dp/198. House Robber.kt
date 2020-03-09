package com.example.kotlinsamples.leetcode.kotlin.dp

/**
 * f(n) = Max(              // max amount to robbed till n
 *           f(n-2) + A[n], // max amount robbed till n-2 and current house
 *           f(n-1)         // max amount robbed till n-1
 *           )
 */
private fun rob(nums: IntArray): Int {
    var dp = IntArray(nums.size)
    fun find(n: Int): Int {
        if (n < 0) return 0
        if (n == 0) return nums[0]
        if (dp[n] == 0) dp[n] = (find(n - 2) + nums[n]).coerceAtLeast(find(n - 1))
        return dp[n]
    }
    return find(nums.size - 1)
}

private fun rob2(nums: IntArray): Int {
    var sl = 0
    var l = 0
    for (n in nums) {
        var m = Math.max(sl + n, l)
        sl = l
        l = m
    }
    return l
}