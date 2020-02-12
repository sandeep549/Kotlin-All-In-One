package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun maximumSwap(num: Int): Int {
    var arr = num.toString().toCharArray()
    var n = arr.size
    for (i in 0 until n) {
        var max = i
        for (j in n - 1 downTo i + 1) {
            if (arr[j].toInt() > arr[max].toInt()) max = j
        }
        if (arr[max].toInt() != arr[i].toInt()) {
            arr[i] = arr[max].also { arr[max] = arr[i] }
            return String(arr).toInt()
        }
    }
    return num
}

fun main() {
    println(maximumSwap(1993))
}