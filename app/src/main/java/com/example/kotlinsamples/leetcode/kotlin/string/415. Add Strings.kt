package com.example.kotlinsamples.leetcode.kotlin.string

private fun addStrings(num1: String, num2: String): String {
    var i = num1.length - 1
    var j = num2.length - 1
    var r = 0
    var c = 0
    var ans: String = ""
    while (i >= 0 || j >= 0 || c > 0) {
        if (i >= 0) c += num1[i--] - '0'
        if (j >= 0) c += num2[j--] - '0'
        ans += (c % 10)
        c = c / 10
    }
    return ans.reversed()
}