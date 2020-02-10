package com.example.kotlinsamples.leetcode.kotlin.array.medium

//https://en.wikipedia.org/wiki/Dutch_national_flag_problem

private fun sortColors(nums: IntArray): Unit {
    var i = 0
    var j = 0
    var k = nums.size
    while (j < k) {
        when {
            nums[j] == 0 -> {
                nums[i] = nums[j].also { nums[j] = nums[i] }
                i++
                j++
            }
            nums[j] == 2 -> {
                k--
                nums[k] = nums[j].also { nums[j] = nums[k] }
            }
            else -> {
                j++
            }
        }
    }
}