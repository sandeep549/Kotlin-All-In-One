package com.example.kotlinsamples.leetcode.kotlin.dp

fun main() {
    //println(maxProfit(intArrayOf(3, 3, 5, 0, 0, 3, 1, 4)))
    println(maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    //println(maxProfit(intArrayOf(7,6,4,3,1)))
}

// 3,2 -> 2,2 -> 1,2 -> 0,2
// 1,1 ->

// 2,1 -> 1,1 ->
// 0,0

private fun maxProfit(prices: IntArray): Int {
    val dp = Array(prices.size) { IntArray(3) { 0 } }
    fun profit(arr: IntArray, i: Int, k: Int): Int {
        println("i=" + i + ", k=" + k)
        if (k <= 0) return 0
        if (i <= 0) return 0
        if (i == 1) {
            dp[i][k] = Math.max(arr[i] - arr[i - 1], 0)
            println("dp[" + i + "][" + k + "]=" + dp[i][k])
            return dp[i][k]
        }

        if (dp[i - 1][k] == 0) profit(arr, i - 1, k)
        if (dp[i - 2][k - 1] == 0) profit(arr, i - 2, k - 1)

        dp[i][k] = Math.max(dp[i - 1][k], prices[i] - prices[i - 1] + dp[i - 2][k - 1])
        println("<-- dp[" + i + "][" + k + "]=" + dp[i][k])
        return dp[i][k]
    }

    return profit(prices, prices.lastIndex, 2)
}