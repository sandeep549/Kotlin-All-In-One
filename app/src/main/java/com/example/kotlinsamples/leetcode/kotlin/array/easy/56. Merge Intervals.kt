package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun merge(intervals: Array<IntArray>): Array<IntArray> {
    if (intervals.isEmpty()) return emptyArray()
    var input = intervals.sortedWith(Comparator { t1, t2 -> t1[0] - t2[0] })
    var ans = ArrayList<IntArray>()
    var item = input[0]
    var curr: IntArray? = null
    for (i in 1..input.lastIndex) {
        curr = input[i]
        if (curr[0] <= item[1]) item[1] = item[1].coerceAtLeast(curr[1])
        else {
            ans.add(item)
            item = curr
        }
    }
    if (ans.isEmpty() || item[1] > ans.last()[1]) ans.add(item)
    return ans.toTypedArray()
}