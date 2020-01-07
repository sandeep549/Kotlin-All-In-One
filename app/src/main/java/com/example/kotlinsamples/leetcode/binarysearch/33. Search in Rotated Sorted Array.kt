package com.example.kotlinsamples.leetcode.binarysearch

fun main() {
//    println(search2(intArrayOf(4, 5, 6, 7, 0, 1, 2), 0))
//    println(search2(intArrayOf(4, 5, 6, 7, 0, 1, 2), 3))
//    println(search2(intArrayOf(5, 1, 3), 1))
}

private fun search(nums: IntArray, target: Int): Int {
    if (nums.isEmpty()) return -1

    //find smallest element, use it's index as rotation count
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

