package com.example.kotlinsamples.leetcode.kotlin.dp

/**
 * f(n) = Max(              // max amount to robbed till n
 *           f(n-2) + A[n], // max amount robbed till n-2 and current house
 *           f(n-1)         // max amount robbed till n-1
 *           )
 */
private fun rob(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    var dp = IntArray(nums.size)
    fun find(n: Int, lastLooted: Boolean): Int {
        if (n < 0) return 0
        if (n == 0) return if (lastLooted) 0 else nums[0]
        if (dp[n] == 0) dp[n] =
            (find(n - 2, lastLooted) + nums[n]).coerceAtLeast(find(n - 1, lastLooted))
        return dp[n]
    }

    var a = find(nums.size - 1, true) // check with excluding first
    dp.forEachIndexed { index, _ -> dp[index] = 0 }
    return a.coerceAtLeast(find(nums.size - 2, false)) // check with excluding last
}

fun main() {
    println(rob2(intArrayOf(2, 2, 3)))
    println(rob2(intArrayOf(1, 2, 3, 1)))
}

private fun rob2(nums: IntArray): Int {
    if (nums.size == 1) return nums[0]
    fun maxx(a: Int, b: Int): Int {
        var sl = 0
        var l = 0
        for (i in a..b) {
            var m = Math.max(sl + nums[i], l)
            sl = l
            l = m
        }
        return l
    }
    return maxx(0, nums.size - 2).coerceAtLeast(maxx(1, nums.size - 1))
}