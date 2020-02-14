package com.example.kotlinsamples.leetcode.kotlin.array.easy

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    println(maxProfit(intArrayOf(7, 6, 4, 3, 1)))

    println(maxProfit2(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit2(intArrayOf(1, 2, 3, 4, 5)))
    println(maxProfit2(intArrayOf(7, 6, 4, 3, 1)))

    println(maxProfit3(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit3(intArrayOf(1, 2, 3, 4, 5)))
    println(maxProfit3(intArrayOf(7, 6, 4, 3, 1)))
}

private fun maxProfit(prices: IntArray): Int {
    var buyprice = -1
    var profit = 0
    for (i in 0 until prices.size) {
        // buy condition
        if (buyprice == -1 && i != prices.lastIndex && prices[i + 1] > prices[i]) {
            buyprice = prices[i]
        }
        // sell condition
        if (buyprice != -1 && i != prices.lastIndex && prices[i + 1] < prices[i]) {
            profit += prices[i] - buyprice
            buyprice = -1
        }
    }
    if (buyprice != -1) {
        profit += prices[prices.lastIndex] - buyprice
    }
    return profit
}

/**
 * Consider each greater element compared to previous as new peak compared previous
 * and keep accumulating delta profit.
 */
private fun maxProfit2(prices: IntArray): Int {
    var ans = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) {
            ans += prices[i] - prices[i - 1]
        }
    }
    return ans
}

/**
 * Traverse from left to right, find every peak followed by valley, and
 * book profit. Keep accumulating the profit and return it.
 */
private fun maxProfit3(prices: IntArray): Int {
    var valley = 0
    var peak = 0
    var profit = 0
    var i = 0
    while (i < prices.size - 1) {
        //going down till we find a valley
        while (i < prices.size - 1 && prices[i + 1] <= prices[i]) i++
        valley = prices[i]

        //going up till we find a peak
        while (i < prices.size - 1 && prices[i + 1] >= prices[i]) i++
        peak = prices[i]

        //time to book profit
        profit += peak - valley
    }
    return profit
}