package com.example.kotlinsamples.leetcode.kotlin.hashtable

import java.util.*
import kotlin.collections.ArrayList

/**
A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Find all strobogrammatic numbers that are of length = n.

Example:

Input:  n = 2
Output: ["11","69","88","96"]
 */

fun main() {
    println(findStrobogrammatic2(2))
}

// O(no count to check * size of each number)
// O(10^n * n)
// Time Limit Exceeded
private fun findStrobogrammatic(n: Int): List<String> {
    var map = mapOf<Char, Char>('0' to '0', '1' to '1', '6' to '9', '8' to '8', '9' to '6')
    fun check(num: String): Boolean {
        var l = 0
        var r = num.length - 1
        var arr = num.toCharArray()
        while (l <= r) {
            if (!map.containsKey(arr[l]) || map.get(arr[l++]) != arr[r--]) return false
        }
        return true
    }

    var ans = ArrayList<String>()
    var start = Math.pow(10.toDouble(), n - 1.toDouble()).toInt()
    if (start == 1) start = 0 // handle single digit case, where we need 0 in input space
    var end = Math.pow(10.toDouble(), n.toDouble()) - 1
    while (start <= end) {
        if (check(start.toString())) ans.add(start.toString())
        start++
    }
    return ans
}

// O(n) recursive
// TODO do it without recursion
fun findStrobogrammatic2(n: Int): List<String>? {
    fun helper(n: Int, m: Int): List<String> {
        if (n == 0) return ArrayList(listOf("")) // its not empty list,list with one empty space item
        if (n == 1) return ArrayList(listOf("0", "1", "8"))
        val list = helper(n - 2, m)
        val res = ArrayList<String>()
        for (i in list.indices) {
            val s = list[i]
            if (n != m) res.add("0" + s + "0")
            res.add("1" + s + "1")
            res.add("6" + s + "9")
            res.add("8" + s + "8")
            res.add("9" + s + "6")
        }
        return res
    }
    return helper(n, n)
}
