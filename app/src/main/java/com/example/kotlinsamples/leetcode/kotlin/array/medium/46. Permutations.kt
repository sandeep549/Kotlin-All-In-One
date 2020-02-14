package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun permute(nums: IntArray): List<List<Int>> {
    var ans = mutableListOf<List<Int>>()
    fun backtrack(set: MutableSet<Int>) {
        if (set.size == nums.size) {
            ans.add(set.toList())
        } else {
            for (ele in nums) {
                if (set.contains(ele)) continue
                set.add(ele)
                backtrack(set)
                set.remove(ele)
            }
        }
    }
    backtrack(mutableSetOf())
    return ans
}