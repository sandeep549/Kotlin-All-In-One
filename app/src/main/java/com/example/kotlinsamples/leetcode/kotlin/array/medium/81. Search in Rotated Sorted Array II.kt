package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun search(nums: IntArray, target: Int): Boolean {
    var l = 0
    var r = nums.lastIndex
    var m = 0
    while (l <= r) {
        m = l + (r - l) / 2
        if (nums[m] == target) return true
        if (nums[l] == nums[m] && nums[r] == nums[m]) {
            l++
            r--
        } else if (nums[l] <= nums[m]) {
            if (target >= nums[l] && target < nums[m]) r = m - 1
            else l = m + 1
        } else {
            if (target > nums[m] && target <= nums[r]) l = m + 1
            else r = m - 1
        }
    }
    return false
}