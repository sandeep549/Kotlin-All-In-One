package com.example.kotlinsamples.leetcode.kotlin.binarysearch

private fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1

    // find smallest element, use it's index as rotation count
    var l = 0
    var r = nums.lastIndex
    var mid = 0
    while (l < r) {
        mid = l + (r - l) / 2
        if (nums[mid] > nums[r]) l = mid + 1
        else r = mid
    }

    var rot = l
    l = 0
    r = nums.lastIndex
    while (l < r) {
        mid = l + (r - l) / 2
        var realmid = (mid + rot) % nums.size
        if (nums[realmid] < target) l = mid + 1
        else r = mid
    }
    return if (nums[(l + rot) % nums.size] == target) (l + rot) % nums.size else -1
}

// from solution
// https://leetcode.com/problems/search-in-rotated-sorted-array/discuss/14435/Clever-idea-making-it-simple
private fun search2(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1
    var l = 0
    var r = nums.lastIndex
    var m = 0
    var MAX = Int.MAX_VALUE
    var MIN = Int.MIN_VALUE
    while (l < r) {
        m = l + (r - l) / 2
        var num = when {
            nums[m] < nums[0] == target < nums[0] -> nums[m]
            target < nums[0] -> MIN
            else -> MAX
        }
        if (num < target) l = m + 1
        else r = m
    }
    return if (nums[l] == target) l else -1
}
