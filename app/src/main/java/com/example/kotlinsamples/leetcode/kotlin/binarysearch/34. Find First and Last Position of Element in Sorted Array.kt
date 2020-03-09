package com.example.kotlinsamples.leetcode.kotlin.binarysearch

fun main() {
    println(searchRange(intArrayOf(1), 1).toList())
}

private fun searchRange(nums: IntArray, target: Int): IntArray {
    var ans = intArrayOf(-1, -1)
    var l = 0
    var r = nums.lastIndex
    var mid = 0
    while (l < r) {
        mid = l + (r - l) / 2 // keep mid towards l side
        if (target > nums[mid]) l = mid + 1
        else r = mid
    }
    ans[0] = if (l == r && nums[l] == target) l else -1

    r = nums.lastIndex
    while (l < r) {
        mid = l + (r - l + 1) / 2 // keep mid towards r side
        if (target >= nums[mid]) l = mid
        else r = mid - 1
    }
    ans[1] = if (l == r && nums[l] == target) l else -1
    return ans
}