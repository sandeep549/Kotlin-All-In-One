package com.example.kotlinsamples.leetcode.kotlin.dp

fun main() {
    minCostClimbingStairs(intArrayOf(0, 0, 1, 1))
}

//top-down
private fun minCostClimbingStairs(cost: IntArray): Int {
    var dp = IntArray(cost.size)
    fun cost(n: Int): Int { // calculates price to reach at step n
        if (n < 0) return 0
        if (n == 0) return cost[0]
        if (dp[n] == 0) dp[n] = Math.min(cost(n - 1), cost(n - 2)) + cost[n]
        return dp[n]
    }
    cost(cost.size - 1)
    return Math.min(dp[cost.size - 1], dp[cost.size - 2]) // to cross last-step(n-1)
}

//bottom-up
private fun minCostClimbingStairs2(cost: IntArray): Int {
    var prepre = 0
    var pre = cost[0] //start from 0th step
    for (i in 1..cost.lastIndex) {
        var curr = Math.min(prepre, pre) + cost[i]
        prepre = pre
        pre = curr
    }
    return Math.min(prepre, pre)
}