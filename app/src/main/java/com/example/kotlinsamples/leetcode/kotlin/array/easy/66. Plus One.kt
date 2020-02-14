package com.example.kotlinsamples.leetcode.kotlin.array.easy

fun main() {
    println(plusOne(intArrayOf(9)).toList())
}

private fun plusOne(digits: IntArray): IntArray {
    for (i in digits.lastIndex downTo 0) {
        if (digits[i] < 9) {
            digits[i]++
            return digits
        }
        digits[i] = 0
    }
    var ans = IntArray(digits.size + 1)
    ans[0] = 1
    return ans
}

private fun plusOne2(digits: IntArray): IntArray {
    var i = digits.size - 1
    var carry = 0
    while (i >= 0) {
        var tmp = digits[i] + carry
        digits[i--] = tmp % 10
        carry = tmp / 10
    }
    if (carry > 0) {
        var arr = IntArray(digits.size + 1)
        arr[0] = carry
        for (i in 1..arr.lastIndex) arr[i] = digits[i - 1]
        return arr
    }
    return digits
}