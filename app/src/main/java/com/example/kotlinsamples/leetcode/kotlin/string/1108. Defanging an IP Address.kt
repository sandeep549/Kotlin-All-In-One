package com.example.kotlinsamples.leetcode.kotlin.string

fun main() {
    println(defangIPaddr("255.100.50.0"))
}

private fun defangIPaddr(address: String): String {
    var ans = StringBuilder()
    var i = 0
    while (i < address.length) {
        if (address[i] == '.') ans.append("[.]")
        else ans.append(address[i])
        i++
    }
    return ans.toString()
}

private fun defangIPaddr2(address: String): String {
    return address.replace(".", "[.]")
}

