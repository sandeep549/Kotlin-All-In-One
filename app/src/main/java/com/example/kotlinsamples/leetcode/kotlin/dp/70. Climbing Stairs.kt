package com.example.kotlinsamples.leetcode.kotlin.dp

fun main() {
    println(climbStairs(2))
}

//top-down using recursion
private fun climbStairs(n: Int): Int {
    var dp = IntArray(n + 1)
    fun ways(n: Int): Int {
        if (n < 0) return 0
        if (n == 0) return 1
        if (dp[n] == 0) dp[n] = ways(n - 1) + ways(n - 2)
        return dp[n]
    }
    return ways(n)
}

//bottom-up
private fun climbStairs2(n: Int): Int {
    var prepre = 1 //ways to come at step 0, we can take some other value also but base case will
    // increase, so better take this as 0
    var pre = 1 // ways to come at step 1, using single step
    var ans = 1 // keep track of ways to reach at every step, keep it 1 to handle where input n is 1
    for (i in 2..n) {
        ans = prepre + pre
        prepre = pre
        pre = ans
    }
    return ans
}