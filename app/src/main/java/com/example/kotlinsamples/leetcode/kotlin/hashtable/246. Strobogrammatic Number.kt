package com.example.kotlinsamples.leetcode.kotlin.hashtable

/**
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to determine if a number is strobogrammatic. The number is represented as a string.

Example 1:

Input:  "69"
Output: true
Example 2:

Input:  "88"
Output: true
Example 3:

Input:  "962"
Output: false
 */

fun main() {
    println(isStrobogrammatic("619"))
    println(isStrobogrammatic("6197"))
}

private fun isStrobogrammatic(num: String): Boolean {
    var map = mapOf<Char, Char>('0' to '0', '1' to '1', '6' to '9', '8' to '8', '9' to '6')
    var l = 0
    var r = num.length - 1
    var arr = num.toCharArray()
    while (l <= r) {
        if (!map.containsKey(arr[l]) || map.get(arr[l++]) != arr[r--]) return false
    }
    return true
}