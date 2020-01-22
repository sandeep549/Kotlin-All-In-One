package com.example.kotlinsamples.leetcode.kotlin.misc

fun main() {
    subtractProductAndSum(5)
}

private fun subtractProductAndSum(n: Int): Int {
    var num = n
    var sum = 0
    var prod = 1
    while (num != 0) {
        sum += num % 10
        prod *= num % 10
        num = num / 10
    }
    return prod - sum
}