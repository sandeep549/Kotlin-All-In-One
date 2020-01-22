package com.example.kotlinsamples.leetcode.kotlin.misc

fun main() {
    println(countPrime(1000000))
    println(countPrime2(1000000))
}

private fun countPrime(num: Int): Int {
    var start = System.currentTimeMillis()
    var notPrime = BooleanArray(num)
    var count = 0
    for (i in 2 until num) {
        if (!notPrime[i]) {
            count++
            var j = 2
            while (i * j < num) {
                notPrime[i * j] = true
                j++
            }
        }
    }
    println("Time taken:" + (System.currentTimeMillis() - start))
    return count
}

private fun countPrime2(num: Int): Int {
    var start = System.currentTimeMillis()
    var count = 0;
    for (i in 2..num) {
        if (isprime(i)) count++
    }
    println("Time taken:" + (System.currentTimeMillis() - start))
    return count
}

private fun isprime(num: Int): Boolean {
    var n: Int = Math.sqrt(num.toDouble()).toInt()
    for (i in 2..n) {
        if (num % i == 0) return false
    }
    return true
}