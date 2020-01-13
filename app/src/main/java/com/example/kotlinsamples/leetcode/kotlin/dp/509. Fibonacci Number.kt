package com.example.kotlinsamples.leetcode.kotlin.dp

import kotlin.math.sign

//recursion
private fun fib(N: Int): Int {
    if (N == 0) return 0
    if (N == 1) return 1
    return fib(N - 1) + fib(N - 2)
}

//dp, top-down
private fun fib2(N: Int): Int {
    var dp = IntArray(N + 1) { 0 }
    fun recur(n: Int): Int {
        if (n == 0) dp[n] = 0
        else if (n == 1) dp[n] = 1
        else if (dp[n] == 0) dp[n] = recur(n - 1) + recur(n - 2)
        return dp[n]
    }
    recur(N)
    return dp[N]
}

//dp, bottom-up
private fun fib3(N: Int): Int {
    var a = 0
    var b = 0 //0th item in series
    var n = N
    while (n-- > 0) {
        var sum = a + if (b > 0) b else 1 //handle 1st item case
        a = b
        b = sum
    }
    return b
}