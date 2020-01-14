package com.example.kotlinsamples.leetcode.kotlin.dp

//dp, top-down
fun uniquePaths(m: Int, n: Int): Int {
    var table = Array(m) { IntArray(n) { 0 } }
    fun ways(r: Int, c: Int): Int = if (r < 0 || c < 0) 0 else table[r][c]
    for (r in 0 until m) {
        for (c in 0 until n) {
            if (r == 0 && c == 0) table[r][c] = 1
            else table[r][c] = ways(r - 1, c) + ways(r, c - 1)
        }
    }
    return table[m - 1][n - 1]
}

//dp, bottom-up
private fun uniquePaths2(m: Int, n: Int): Int {
    var dp = Array(m) { IntArray(n) { 0 } }
    fun waystoReach(r: Int, c: Int): Int { // finds no of ways to reach at location (r, c)
        if (r < 0 || c < 0) return 0
        if (r == 0 && c == 0) return 1 //we reach at origin, base case
        if (dp[r][c] == 0) dp[r][c] = waystoReach(r, c - 1) + waystoReach(r - 1, c)
        return dp[r][c]
    }
    return waystoReach(m - 1, n - 1)
}