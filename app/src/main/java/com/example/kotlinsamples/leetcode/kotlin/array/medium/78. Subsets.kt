package com.example.kotlinsamples.leetcode.kotlin.array.medium

import kotlin.math.pow


private fun subsets(nums: IntArray): List<List<Int>> {
    val output = mutableListOf<MutableList<Int>>()
    output.add(ArrayList())

    for (num in nums) {
        val newSubsets = mutableListOf<MutableList<Int>>()
        for (curr in output) {
            ArrayList(curr).let {
                it.add(num)
                newSubsets.add(it)
            }
        }
        output.addAll(newSubsets)
    }

    return output
}

private fun subsets2(nums: IntArray): List<List<Int>> {
    val output = mutableListOf<MutableList<Int>>()
    val n = nums.size

    for (i in 2.toDouble().pow(n).toInt() until 2.toDouble().pow(n + 1).toInt()) { // generate bitmask, from 0..00 to 1..11
        val bitmask = Integer.toBinaryString(i).substring(1)
        // append subset corresponding to that bitmask
        val curr = mutableListOf<Int>()
        for (j in 0 until n) {
            if (bitmask[j] == '1') curr.add(nums[j])
        }
        output.add(curr)
    }
    return output
}

private fun subsets3(nums: IntArray): List<List<Int>> {
    var ans = mutableListOf<List<Int>>()
    fun backtrack(tmpList: MutableList<Int>, start: Int) {
        ans.add(tmpList.toList())
        for (i in start..nums.lastIndex) {
            tmpList.add(nums[i])
            backtrack(tmpList, i + 1)
            tmpList.removeAt(tmpList.lastIndex)
        }
    }
    backtrack(mutableListOf(), 0)
    return ans
}