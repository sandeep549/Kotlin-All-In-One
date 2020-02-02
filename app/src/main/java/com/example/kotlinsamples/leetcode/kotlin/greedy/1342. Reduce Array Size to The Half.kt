package com.example.kotlinsamples.leetcode.kotlin.greedy


private fun minSetSize(arr: IntArray): Int {
    var map = arr.groupBy { it }.mapValues { it.value.size }.toList().sortedByDescending { it.second }
    var cnt = 0
    var ans = 0
    for (entry in map) {
        if (cnt >= (arr.size + 1) / 2) break
        cnt += entry.second
        ans++
    }
    return ans
}

//todo: see https://leetcode.com/problems/reduce-array-size-to-the-half/discuss/496714/Java-O(N)-solution