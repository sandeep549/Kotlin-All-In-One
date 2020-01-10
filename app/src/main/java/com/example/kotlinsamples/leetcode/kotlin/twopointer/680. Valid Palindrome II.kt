package com.example.kotlinsamples.leetcode.kotlin.twopointer

fun main() {
    println(validPalindrome("abca"))
    println(validPalindrome2("abc"))
}

private fun validPalindrome(s: String): Boolean {
    fun check(s: String, l: Int, r: Int): Boolean {
        for (i in l until (l + (r - l) / 2)) {
            if (s[i] != s[r - i + l]) return false
        }
        return true
    }
    for (k in 0 until s.length / 2) {
        if (s[k] != s[s.length - 1 - k]) {
            return (check(s, k + 1, s.length - 1 - k) || check(s, k, s.length - 1 - k - 1))
        }
    }
    return true
}

private fun validPalindrome2(s: String): Boolean {
    fun check(s: String, i: Int, j: Int): Boolean {
        var l = i
        var r = j
        while (l < r) {
            if (s[l++] != s[r--]) return false
        }
        return true
    }

    var l = 0
    var r = s.length - 1
    while (l < r) {
        if (s[l] != s[r]) {
            return (check(s, l + 1, r) || check(s, l, r - 1))
        }
        l++
        r--
    }
    return true
}