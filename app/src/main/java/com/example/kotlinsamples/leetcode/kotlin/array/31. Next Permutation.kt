package com.example.kotlinsamples.leetcode.kotlin.array

private fun nextPermutation(nums: IntArray) {
    fun reverse(nums: IntArray, l: Int, r: Int) {
        var l = l
        var r = r
        var nums = nums
        while (l < r) {
            nums[l] = nums[r].also { nums[r] = nums[l] }
            l++
            r--
        }
    }
    //find first element from right which is smaller than previous
    var i = nums.size - 2
    while (i >= 0 && nums[i] >= nums[i + 1]) i--
    if (i >= 0) {
        //find first from right whic is just grater than ith element
        var j = nums.size - 1
        while (j >= 0 && nums[j] <= nums[i]) j--
        nums[i] = nums[j].also { nums[j] = nums[i] }
    }
    reverse(nums, i + 1, nums.size - 1)
}