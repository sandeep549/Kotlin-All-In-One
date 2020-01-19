package com.example.kotlinsamples.leetcode.kotlin

private fun printVertically(s: String): List<String> {
    var inputList = s.split(" ")
    var ans = ArrayList<String>()
    var maxlen = inputList.maxBy { it.length }?.length ?: 0
    for (i in 0 until maxlen) {
        var builder = StringBuilder()
        for (s in inputList) {
            builder.append(if (i < s.length) s[i] else " ")
        }
        ans.add(builder.trimEnd().toString())
    }
    return ans
}