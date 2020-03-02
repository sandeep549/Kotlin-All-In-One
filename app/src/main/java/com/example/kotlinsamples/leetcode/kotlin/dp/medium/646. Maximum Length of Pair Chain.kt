package com.example.kotlinsamples.leetcode.kotlin.dp.medium

private fun findLongestChain(pairs: Array<IntArray>): Int {
    var ans = 0
    fun chainAt(last: Int?, set: MutableSet<Int>) {
        for (j in pairs.indices) {
            if (set.contains(j)) continue
            if (last == null || pairs[j][0] > last) {
                set.add(j)
                ans = maxOf(ans, set.size)
                chainAt(pairs[j][1], set)
                set.remove(j)
            }
        }
    }
    chainAt(null, sortedSetOf())
    return ans
}

fun main() {
    println(
        findLongestChain(
            arrayOf(
                intArrayOf(3, 4),
                intArrayOf(2, 3),
                intArrayOf(1, 2)
            )
        )
    )
}