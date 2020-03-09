package com.example.kotlinsamples.leetcode.kotlin.binarysearch

/**
 * I understand that square root finding is complex problem and it require a through study for some mathematics algorithms,
 * But as question does not need exact decimal points and aproximation, we can stick to this descrition and write simple algorithms.
 * PS: Though I understand we need to know all these algorithms mentioned in best answers, but this question actually doesn't demand it.
 */

/**
 * Seems like all 3 solutions are constant time complexity, can someone correct if I'm wrong ?
 * Solution 1 (Brute Force): O(sqrt(x)) ≈ O(46340)=O(1)
 * Solution 2 (Newtons Method): O(lg(x)) ≈ O(32)=O(1)
 * Solution 3 (Binary Search): O(lg(x)) ≈ O(32)=O(1)
 */

// brute force
private fun mySqrt(x: Int): Int {
    var i = 1
    while (i <= x / i) {
        if (i > x / i) break
        i++
    }
    return i - 1
}

// newton's method
private fun mySqrt2(x: Int): Int {
    if (x == 0) return 0
    var i = x.toLong()
    while (i > x / i) i = (i + x / i) / 2
    return i.toInt()
}

// binary search
private fun mySqrt3(x: Int): Int {
    var l = 1
    var r = x
    var mid = 0
    while (l < r) {
        mid = l + (r - l) / 2
        if (mid < x / mid) l = mid + 1
        else r = mid
    }
    return if (l == x / l) l else l - 1
}