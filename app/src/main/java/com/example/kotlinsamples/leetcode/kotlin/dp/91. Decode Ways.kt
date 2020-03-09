package com.example.kotlinsamples.leetcode.kotlin.dp

private fun numDecodings(s: String): Int {
    fun isValid(i: Int) = s[i] != '0'
    fun isValid(i: Int, j: Int) = (s[i] != '0' && s.substring(i, j + 1).toInt() <= 26)

    fun ways(n: Int): Int { // ways to decode til index n
        if (n < 0) return 1 // valid decoding when right part is valid and nothing left on left side
        if (n == 0 && s[n] == '0') return 0
        if (n == 0) return 1
        var a = 0
        if (isValid(n)) a += ways(n - 1)
        if (isValid(n - 1, n)) a += ways(n - 2)
        return a
    }
    return ways(s.lastIndex)
}

private fun numDecodings2(s: String): Int {
    fun isValid(i: Int) = s[i] != '0'
    fun isValid(i: Int, j: Int) = (s[i] != '0' && s.substring(i, j + 1).toInt() <= 26)

    var dp = IntArray(s.length + 1) { -1 }
    fun ways(n: Int): Int { // ways to decode til index n
        if (n >= 0 && dp[n] != -1) return dp[n]
        if (n < 0) return 1 // valid decoding when right part is valid and nothing left on left side
        if (n == 0 && s[n] == '0') return 0
        if (n == 0) {
            dp[n] = 1
            return 1
        }
        var a = 0
        if (isValid(n)) a += ways(n - 1)
        if (isValid(n - 1, n)) a += ways(n - 2)
        dp[n] = a
        return dp[n]
    }
    ways(s.lastIndex)
    return if (dp[s.lastIndex] == -1) 0 else dp[s.lastIndex]
}

fun main() {
    println(numDecodings("12"))
    println(numDecodings("226"))
    println(numDecodings("10"))
    println(numDecodings("27"))
}