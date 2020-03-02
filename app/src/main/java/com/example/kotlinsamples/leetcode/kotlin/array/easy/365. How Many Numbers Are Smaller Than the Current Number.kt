package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
    fun find(arr: IntArray, item: Int): Int {
        var l = 0
        var r = arr.size - 1
        while (l < r) {
            var m = l + (r - l) / 2
            if (item > arr[m]) l = m + 1
            else r = m
        }
        return l
    }

    var copy = nums.copyOf().sortedArray()
    var ans = IntArray(nums.size)
    for (i in nums.indices) {
        ans[i] = find(copy, nums[i])
    }
    return ans
}

private fun smallerNumbersThanCurrent2(nums: IntArray): IntArray {
    var count = IntArray(101)
    for (item in nums) count[item]++
    for (i in 1..count.lastIndex) count[i] += count[i - 1]
    var ans = IntArray(nums.size)
    for (i in nums.indices) {
        if (nums[i] == 0) ans[i] = 0
        else ans[i] = count[nums[i] - 1]
    }
    return ans
}