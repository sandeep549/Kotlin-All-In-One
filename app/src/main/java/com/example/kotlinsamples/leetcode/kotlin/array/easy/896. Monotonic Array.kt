package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun isMonotonic(A: IntArray): Boolean {
    var inc = true
    var dec = true
    for (i in 1 until A.size) {
        if (A[i] >= A[i - 1]) dec = false
        if (A[i] <= A[i - 1]) inc = false
    }
    return (inc || dec)
}