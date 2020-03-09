package com.example.kotlinsamples.leetcode.kotlin.twopointer

// O(n^2)
private fun threeSum(num: IntArray): List<List<Int>> {
    num.sort()
    val res = mutableListOf<List<Int>>()
    for (i in 0 until num.size - 2) {
        if (i == 0 || i > 0 && num[i] != num[i - 1]) {
            var lo = i + 1
            var hi = num.size - 1
            val sum = 0 - num[i]
            while (lo < hi) {
                if (num.get(lo) + num.get(hi) == sum) {
                    res.add(listOf(num[i], num[lo], num[hi]))
                    while (lo < hi && num[lo] == num[lo + 1]) lo++
                    while (lo < hi && num[hi] == num[hi - 1]) hi--
                    lo++
                    hi--
                } else if (num[lo] + num[hi] < sum) lo++ else hi--
            }
        }
    }
    return res
}