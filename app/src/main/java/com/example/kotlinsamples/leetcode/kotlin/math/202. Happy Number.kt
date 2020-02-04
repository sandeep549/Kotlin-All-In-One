package com.example.kotlinsamples.leetcode.kotlin.math

private fun isHappy(n: Int): Boolean {
    fun next(n: Int): Int {
        var n = n
        var res = 0
        while (n > 0) {
            res += (n % 10) * (n % 10)
            n /= 10
        }
        return res
    }

    var slow = next(n)
    var fast = next(next(n))
    while (fast != 1 && slow != fast) {
        slow = next(slow)
        fast = next(next(fast))
    }
    return fast == 1
}