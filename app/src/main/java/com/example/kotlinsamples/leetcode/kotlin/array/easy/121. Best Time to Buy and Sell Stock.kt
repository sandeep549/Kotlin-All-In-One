package com.example.kotlinsamples.leetcode.kotlin.array.easy

import kotlin.math.max

fun main() {
    println(maxProfit2(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit2(intArrayOf(7, 6, 4, 3, 1)))

    println(maxProfit3(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit3(intArrayOf(7, 6, 4, 3, 1)))
}

/**
 * Try with buy stock on each day and check the profit if we sell it on
 * every right side of it, retaining max profit found so far
 */
private fun maxProfit(prices: IntArray): Int {
    var max = 0
    for (i in 0..prices.size - 2) {
        for (j in i + 1..prices.size - 1) {
            max = max(max, prices[j] - prices[i])
        }
    }
    return max
}

private fun maxProfit2(prices: IntArray): Int {
    var maxendinghere = 0
    var maxsofar = 0
    for (i in 1..prices.lastIndex) {
        maxendinghere += prices[i] - prices[i - 1]
        maxendinghere = max(0, maxendinghere)
        maxsofar = max(maxsofar, maxendinghere)
    }
    return maxsofar
}

/**
 * Iterate from left to right, try selling at every point retaining max profit found so far,
 * and min found so far.
 */
private fun maxProfit3(arr: IntArray): Int {
    if (arr.isEmpty()) return 0
    var min = arr[0]
    var ans = 0
    for (i in 1..arr.lastIndex) {
        ans = Math.max(ans, arr[i] - min)
        min = Math.min(min, arr[i])
    }
    return ans
}