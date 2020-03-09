package com.example.kotlinsamples.leetcode.kotlin.twopointer

fun main() {
    println(sortedSquares(intArrayOf(-4, -1, 0, 3, 10)).toList())
}

private fun sortedSquares(arr: IntArray): IntArray {
    var m = arr.indices.minBy { Math.abs(arr[it]) }!!
    var ans = IntArray(arr.size)
    var k = 0
    ans[k++] = arr[m] * arr[m]
    var i = m - 1
    var j = m + 1
    while (k < ans.size) {
        if (i >= 0 && j <= arr.size - 1) {
            if (Math.abs(arr[i]) <= Math.abs(arr[j])) {
                ans[k++] = arr[i] * arr[i]
                i--
            } else {
                ans[k++] = arr[j] * arr[j]
                j++
            }
        } else if (i >= 0) {
            ans[k++] = arr[i] * arr[i]
            i--
        } else if (j <= arr.size - 1) {
            ans[k++] = arr[j] * arr[j]
            j++
        }
    }
    return ans
}