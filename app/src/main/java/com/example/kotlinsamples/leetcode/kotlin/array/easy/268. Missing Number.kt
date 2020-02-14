package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun missingNumber(nums: IntArray): Int {
    return (nums.size * (nums.size + 1)) / 2 - nums.sum()
}

private fun missingNumber2(nums: IntArray): Int {
    var ans = nums.reduceIndexed { index, acc, _ -> acc.xor(index).xor(nums[index]) }
    return ans.xor(nums.size)
}