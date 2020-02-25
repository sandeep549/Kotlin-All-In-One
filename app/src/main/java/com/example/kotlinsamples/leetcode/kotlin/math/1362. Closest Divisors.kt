package com.example.kotlinsamples.leetcode.kotlin.math

import kotlin.math.sqrt


private fun closestDivisors(num: Int): IntArray {
    var a = sqrt(num + 1.toDouble()).toInt()
    if (a * a == num + 1) return intArrayOf(a, a)
    a = sqrt(num + 2.toDouble()).toInt()
    if (a * a == num + 2) return intArrayOf(a, a)
    a++
    var b = a
    while (b != 0) {
        var m = a * b
        if (m > num + 2) {
            b--
        } else if (m < num + 1) {
            a++
        } else {
            return intArrayOf(a, b)
        }
    }
    return intArrayOf(-1, -1)
}

private fun closestDivisors2(x: Int): IntArray {
    for (a in sqrt(x + 2.toDouble()).toInt() downTo 1) {
        if ((x + 1) % a == 0) return intArrayOf(a, (x + 1) / a)
        if ((x + 2) % a == 0) return intArrayOf(a, (x + 2) / a)
    }
    return intArrayOf()
}

fun main() {
    println(closestDivisors(8).toList())
    println(closestDivisors(123).toList())
    println(closestDivisors(999).toList())
}