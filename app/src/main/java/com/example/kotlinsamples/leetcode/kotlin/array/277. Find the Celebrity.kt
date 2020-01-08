package com.example.kotlinsamples.leetcode.kotlin.array

// librayr function given in question, sample implementation
fun knows(a: Int, b: Int): Boolean = true

private fun findCelebrity(n: Int): Int {
    var flag = false
    for (i in 0..n - 1) {
        //lets say i is celebrity
        flag = true
        for (j in 0..n - 1) {
            if (i == j) continue
            if (knows(i, j) || !knows(j, i)) {
                flag = false
                break
            }
        }
        if (flag) return i // found celebrity
    }
    return -1
}