package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun singleNumber(nums: IntArray): IntArray {
    var bitmask = 0
    for (a in nums) bitmask = bitmask.xor(a)
    var diff = bitmask.and(-bitmask)
    var ans = intArrayOf(0, 0)
    for (a in nums) {
        if (diff.and(a) == 0) ans[0] = ans[0].xor(a)
        else ans[1] = ans[1].xor(a)
    }
    return ans
}