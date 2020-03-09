package com.example.kotlinsamples.leetcode.kotlin.dp

/**
 * ith fence can be painted in 2 ways, same as previous OR different than previous.
 *
 * Ways to paint ith fence is =
 *              Ways to paint ith fence when its painted with same color as (i-1)th
 *              +
 *              Ways to paint ith fence when its painted with different color as (i-1)th
 *
 * ways(i) = ways(i-2) * (k-1) // As current and previous has same color, means i-2 color will be different, so we have k-1 color available to paint both in same color
 *           +
 *           ways(i-1) * (k-1) // As we have left with k-1 colors to paint this differently from previous
 *
 *
 */

// dp, top-down recursive
private fun numWays(n: Int, k: Int): Int {
    var dp = IntArray(n + 1) { 0 }
    fun ways(n: Int): Int {
        if (n <= 0 || k <= 0) return 0
        // one fence can be painted in k ways
        if (n == 1) dp[n] = k
        if (n == 2) dp[n] = k * k // special base case
        if (dp[n] == 0) dp[n] = (k - 1) * ways(n - 2) + (k - 1) * ways(n - 1)
        return dp[n]
    }
    ways(n) // init dp table, u can also return this
    return dp[n]
}

// bottom-up, iterative
private fun numways2(n: Int, k: Int): Int {
    if (n == 0) return 0
    if (n == 1) return k
    if (n == 2) return k * k

    val table = IntArray(n + 1)
    table[0] = 0
    table[1] = k
    table[2] = k * k
    for (i in 3..n) { // the recursive formula that we derived
        table[i] = (table[i - 1] + table[i - 2]) * (k - 1)
    }
    return table[n]
}