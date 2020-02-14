package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun subsetsWithDup(nums: IntArray): List<List<Int>> {
    var ans = mutableListOf<List<Int>>()
    fun backtrack(tmpList: MutableList<Int>, start: Int) {
        ans.add(tmpList.toList())
        for (i in start..nums.lastIndex) {
            if (i > start && nums[i] == nums[i - 1]) continue
            tmpList.add(nums[i])
            backtrack(tmpList, i + 1)
            tmpList.removeAt(tmpList.lastIndex)
        }
    }
    nums.sort()
    backtrack(mutableListOf(), 0)
    return ans
}

//todo: try with iteration approach