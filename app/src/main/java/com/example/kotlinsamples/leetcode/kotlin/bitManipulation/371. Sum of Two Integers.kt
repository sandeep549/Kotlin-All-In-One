package com.example.kotlinsamples.leetcode.kotlin.bitManipulation

private fun getSum(a: Int, b: Int): Int {
    var a = a
    var b = b
    while (b != 0) {
        var carry = a.and(b) // carry contains common set bits
        a = a.xor(b) // sum of bits where at least 1 common bit is not set
        carry = carry.shl(1) // carry needs to be added 1 place left side
        b = carry
    }
    return a
}