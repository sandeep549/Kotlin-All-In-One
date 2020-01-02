package com.example.kotlinsamples.leetcode.array

fun main() {
    println(plusOne(intArrayOf(9)).toList())
}

private fun plusOne(digits: IntArray): IntArray {
    var i = digits.size - 1
    while (i >= 0) {
        if (digits[i] < 9) {
            digits[i]++
            return digits
        }
        digits[i--] = 0
    }
    var newArr = IntArray(digits.size + 1)
    newArr[0] = 1
    return newArr
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