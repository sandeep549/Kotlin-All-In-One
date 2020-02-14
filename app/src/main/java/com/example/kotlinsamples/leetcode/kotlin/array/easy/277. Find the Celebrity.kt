package com.example.kotlinsamples.leetcode.kotlin.array.easy

// library function given in question, sample implementation
fun knows(a: Int, b: Int): Boolean = true

private fun findCelebrity(n: Int): Int {
    var flag = false
    for (i in 0..n - 1) {
        //lets say i is celebrity
        flag = true
        for (j in 0..n - 1) {
            if (i == j) continue
            if (knows(
                    i,
                    j
                ) || !knows(j, i)
            ) {
                flag = false
                break
            }
        }
        if (flag) return i // found celebrity
    }
    return -1
}

/**
 * 1. After first loop, say k is candidate, then candidate k do not know k+1..n-1
 * 2. We need check whether candidate also do not know from 0 to k-1(i.e. second loop)
 * 3. We also need to cross check whether all other must know our candidate k (i.e. last loop)
 */
private fun findCelebrity2(n: Int): Int {
    var candidate = 0
    for (i in 0 until n) if (knows(candidate, i)) candidate = i
    for (i in 0 until candidate) if (knows(candidate, i)) return -1
    for (i in 0 until n) if (!knows(i, candidate)) return -1
    return candidate
}