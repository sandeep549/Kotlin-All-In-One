package com.example.kotlinsamples.leetcode

private fun singleNumber(nums: IntArray): Int {
    var res = 0
    for (i in nums) res = res.xor(i)
    return res
}

private fun singleNumver2(nums: IntArray): Int {
    return nums.reduce { acc, i -> acc.xor(i) }
}