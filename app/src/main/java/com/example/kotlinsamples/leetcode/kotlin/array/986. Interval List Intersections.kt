package com.example.kotlinsamples.leetcode.kotlin.array


private fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
    var i = 0
    var j = 0
    var anslist = mutableListOf<IntArray>()
    while (i < A.size && j < B.size) {
        if (A[i][1] < B[j][0]) i++ //A's end is less than B's start, no intersection, move in A
        else if (B[j][1] < A[i][0]) j++ //B's end is less than a's start, no intersection, move in B
        else { //intersection case
            anslist.add(intArrayOf(maxOf(A[i][0], B[j][0]), minOf(A[i][1], B[j][1])))
            if (A[i][1] < B[j][1]) i++
            else j++
        }
    }
    return anslist.toTypedArray()
}

private fun intervalIntersection2(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
    var anslist = mutableListOf<IntArray>()
    var i = 0
    var j = 0
    while (i < A.size && j < B.size) {
        val lo: Int = Math.max(A[i][0], B[j][0])
        val hi: Int = Math.min(A[i][1], B[j][1])
        if (lo <= hi) anslist.add(intArrayOf(lo, hi))
        // Remove the interval with the smallest endpoint
        if (A[i][1] < B[j][1]) i++ else j++
    }

    return anslist.toTypedArray()
}