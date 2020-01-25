package com.example.kotlinsamples.leetcode.kotlin.misc

fun main() {
    println(arrayRankTransform(intArrayOf(40, 10, 20, 30)).toList())
    println(arrayRankTransform(intArrayOf(100, 100, 100)).toList())
    println(arrayRankTransform(intArrayOf(37, 12, 28, 9, 100, 56, 80, 5, 12)).toList())
}

private fun arrayRankTransform(arr: IntArray): IntArray {
    var sorted = arr.copyOf().sortedArray()
    var map = mutableMapOf<Int, Int>()
    var rank = 1
    for (i in sorted.indices) {
        if (i > 0 && sorted[i] > sorted[i - 1])
            map.put(sorted[i], ++rank)
        else
            map.put(sorted[i], rank)
    }
    for (i in arr.indices)
        arr[i] = map.get(arr[i])!!
    return arr
}