package com.example.kotlinsamples.leetcode.kotlin.math

private fun divide(dividend: Int, divisor: Int): Int {
    if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE
    var a: Long = Math.abs(dividend.toLong())
    var b: Long = Math.abs(divisor.toLong())
    var sign = (if (dividend < 0) -1 else 1) * (if (divisor < 0) -1 else 1)
    var cnt = 0
    while (a >= b) {
        a -= b
        cnt++
    }
    return cnt * sign
}

private fun divide2(dividend: Int, divisor: Int): Int {
    if (dividend == Int.MIN_VALUE && divisor == -1) return Int.MAX_VALUE
    var sign = (if (dividend < 0) -1 else 1) * (if (divisor < 0) -1 else 1)
    var a: Long = Math.abs(dividend.toLong())
    var b: Long = Math.abs(divisor.toLong())
    var ans = 0
    while (a >= b) {
        var m = 1
        var tmp = b
        while (tmp.shl(1) <= b) {
            tmp = tmp.shl(1)
            m = m.shl(1)
        }
        a -= tmp
        ans += m
    }

    return ans * sign
}