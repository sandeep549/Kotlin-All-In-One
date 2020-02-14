package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun checkIfExist(arr: IntArray): Boolean {
    var set = mutableSetOf<Int>()
    for (a in arr) {
        if ((a % 2 == 0 && set.contains(a / 2)) || set.contains(2 * a)) return true
        set.add(a)
    }
    return false
}