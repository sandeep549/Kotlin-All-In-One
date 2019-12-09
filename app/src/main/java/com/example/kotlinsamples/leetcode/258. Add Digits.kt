package com.example.kotlinsamples.leetcode

fun main() {
    println(addDigits(38))
}

private fun addDigits(num: Int): Int {
    return 1 + num.dec() % 9
}

private fun addDigits2(num: Int): Int {
    var n = num
    var r = 0
    while (true) {
        r = sumdigits(n)
        if (r / 10 == 0) return r
        else n = r
    }
}

private fun sumdigits(num: Int): Int {
    var s = 0
    var n = num
    while (n != 0) {
        s += n % 10
        n /= 10
    }
    return s
}