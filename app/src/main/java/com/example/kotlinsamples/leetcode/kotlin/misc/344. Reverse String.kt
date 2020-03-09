package com.example.kotlinsamples.leetcode.kotlin.misc

fun reverseString(s: CharArray) {
    for (i in 0..s.size / 2 - 1) {
        s[i] = s[s.size - 1 - i].also { s[s.size - 1 - i] = s[i] }
    }
}

fun reverseString2(s: CharArray) {
    s.reverse()
}

fun reverseString3(s: CharArray) {
    var start = 0
    var end = s.lastIndex
    while (start < end) {
        s[start] = s[end].also { s[end] = s[start] }
        start++
        end--
    }
}