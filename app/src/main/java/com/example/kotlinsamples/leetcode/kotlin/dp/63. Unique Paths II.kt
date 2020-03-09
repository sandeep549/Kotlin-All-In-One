package com.example.kotlinsamples.leetcode.kotlin.dp

fun main() {
    println(
        uniquePathsWithObstacles2(
            arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 1, 0),
                intArrayOf(0, 0, 0)
            )
        )
    )
}

/**
 * dp, top-down
 * f(r,c) = f(r,c-1) + f(r-1, c)
 * f(r,c) = no of ways to reach at location (r,c)
 * f(r,c-1) = no of ways to reach at location (r,c-1), i.e. from left side
 * f(r-1,c) = no of ways to reach at location (r-1,c), i.e. from up side
 */
private fun uniquePathsWithObstacles(m: Array<IntArray>): Int {
    var dp = Array(m.size) { IntArray(m.first().size) { 0 } }
    fun waystoReach(r: Int, c: Int): Int { // finds no of ways to reach at location (r, c)
        if (r < 0 || c < 0 || m[r][c] == 1) return 0
        if (r == 0 && c == 0) return 1 // we reach at origin, base case
        if (dp[r][c] == 0) dp[r][c] = waystoReach(r, c - 1) + waystoReach(r - 1, c)
        return dp[r][c]
    }
    return waystoReach(m.size - 1, m.first().size - 1)
}

// dp, bottom-up
private fun uniquePathsWithObstacles2(m: Array<IntArray>): Int {
    fun ways(r: Int, c: Int): Int = if (r < 0 || c < 0) 0 else m[r][c]
    for (r in m.indices) {
        for (c in m.first().indices) {
            if (r == 0 && c == 0 && m[r][c] == 0) m[r][c] = 1
            else m[r][c] = if (m[r][c] == 0) ways(r - 1, c) + ways(r, c - 1) else 0
        }
    }
    return m[m.size - 1][m.first().size - 1]
}