package com.example.kotlinsamples.leetcode.kotlin.string

import java.lang.StringBuilder

fun main() {
    println(addBinary2("11", "1"))
}

private fun addBinary(a: String, b: String): String {
    var i = a.length - 1
    var j = b.length - 1
    var ans = ""
    var carry = 0
    var r = 0
    var curr = 0
    while (i >= 0 && j >= 0) {
        curr = ((a[i--] - '0') + (b[j--] - '0') + carry)
        r = curr % 2
        carry = curr / 2
        ans += r
    }
    while (i >= 0) {
        curr = a[i--] - '0'
        curr += carry
        r = curr % 2
        carry = curr / 2
        ans += r
    }
    while (j >= 0) {
        curr = b[j--] - '0'
        curr += carry
        r = curr % 2
        carry = curr / 2
        ans += r
    }
    if (carry > 0) ans += carry.toString()
    return ans.reversed()
}

private fun addBinary2(a: String, b: String): String {
    var ans = StringBuilder()
    var i = a.length - 1
    var j = b.length - 1
    var sum = 0
    var carry = 0
    while (i >= 0 || j >= 0 || carry > 0) {
        sum = carry
        if (i >= 0) sum += a[i--] - '0'
        if (j >= 0) sum += b[j--] - '0'
        ans.append(sum % 2)
        carry = sum / 2
    }
    return ans.reverse().toString()
}