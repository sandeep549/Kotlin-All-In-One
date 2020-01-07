package com.example.kotlinsamples.leetcode.kotlin.array

import kotlin.math.max

fun main() {
    println(maxProfit2(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit2(intArrayOf(7, 6, 4, 3, 1)))

    println(maxProfit3(intArrayOf(7, 1, 5, 3, 6, 4)))
    println(maxProfit3(intArrayOf(7, 6, 4, 3, 1)))
}

private fun maxProfit(prices: IntArray): Int {
    var maxprofit = 0
    for (i in 0..prices.size - 2) {
        for (j in i + 1..prices.size - 1) {
            maxprofit = max(maxprofit, prices[j] - prices[i])
        }
    }
    return maxprofit
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

private fun maxProfit3(prices: IntArray): Int {
    var minprice = Int.MAX_VALUE // min price so far
    var maxprofit = 0 // max profit so far
    for (price in prices) {
        if (price < minprice) {
            minprice = price
        } else if (price - minprice > maxprofit) {
            maxprofit = price - minprice
        }
    }
    return maxprofit
}