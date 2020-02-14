package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun combinationSum3(k: Int, n: Int): List<List<Int>> {
    var ans = mutableListOf<List<Int>>()
    var candidates = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
    fun backtrack(tmpList: MutableList<Int>, remaining: Int, start: Int) {
        if (remaining < 0) return
        if (remaining == 0 && tmpList.size == k) ans.add(tmpList.toList())
        else {
            for (i in start..candidates.lastIndex) {
                tmpList.add(candidates[i])
                backtrack(tmpList, remaining - candidates[i], i + 1)
                tmpList.removeAt(tmpList.lastIndex)
            }
        }
    }
    backtrack(mutableListOf(), n, 0)
    return ans
}