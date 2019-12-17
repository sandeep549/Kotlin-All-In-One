package com.example.kotlinsamples.leetcode.array

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

private fun maxProfit2(prices: IntArray): Int {
    var profit = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) {
            profit += prices[i] - prices[i - 1]
        }
    }
    return profit
}

private fun maxProfit3(prices: IntArray): Int {
    var valley = prices[0]
    var peak = prices[0]
    var profit = 0
    var i = 0
    while (i < prices.size - 1) {
        while (i < prices.size - 1 && prices[i + 1] <= prices[i]) {
            i++
        }
        valley = prices[i]
        while (i < prices.size - 1 && prices[i + 1] >= prices[i]) {
            i++
        }
        peak = prices[i]
        profit += peak - valley
    }
    return profit
}