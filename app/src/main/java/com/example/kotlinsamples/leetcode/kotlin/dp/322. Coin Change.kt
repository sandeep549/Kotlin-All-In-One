package com.example.kotlinsamples.leetcode.kotlin.dp

private fun coinChange(coins: IntArray, amount: Int): Int {
    var dp = IntArray(amount + 1) { -1 }

    fun getMinCountForAmount(amount: Int): Int {
        if (amount == 0) return 0
        if (dp[amount] != -1) return dp[amount]
        var min = Int.MAX_VALUE
        for (coin in coins) {
            if (amount - coin >= 0) {
                var m = getMinCountForAmount(amount - coin)
                if (m >= 0 && m < min) {
                    min = minOf(min, m + 1)
                }
            }
        }
        dp[amount] = if (min == Int.MAX_VALUE) -1 else min
        return dp[amount]
    }

    var ans = getMinCountForAmount(amount)
    return if (ans < 0) -1 else ans
}

//private fun coinChange2(coins: IntArray, amount: Int): Int {
//    var MAX = amount + 1 // We can not have more coins than amount
//    var dp = Array<Int?>(amount + 1) { null }
//
//    fun getMinCoinsFor(amount: Int): Int? {
//        if (amount < 0) return MAX
//        if (amount == 0) return 0
//        if (dp[amount] != null) return dp[amount]
//        var min = MAX
//        for (coin in coins) min = minOf(min, 1 + getMinCoinsFor(amount - coin)!!)
//        dp[amount] = min
//        return min
//    }
//    return if (getMinCoinsFor(amount) == MAX) -1 else amount
//}

//todo: try to get coin used for min i.e. which coin is used in what count to get minimum
fun main() {
    println(coinChange(intArrayOf(1, 2, 5), 11))
    println(coinChange(intArrayOf(2), 3))
    println(coinChange(intArrayOf(186, 419, 83, 408), 6249))
}

