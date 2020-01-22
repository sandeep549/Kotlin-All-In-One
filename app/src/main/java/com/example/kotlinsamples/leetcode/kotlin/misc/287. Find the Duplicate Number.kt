package com.example.kotlinsamples.leetcode.kotlin.misc

private fun findDuplicate(nums: IntArray): Int {
    // Find the intersection point of the two runners.
    var tortoise = nums[0]
    var hare = nums[0]
    do {
        tortoise = nums[tortoise]
        hare = nums[nums[hare]]
    } while (tortoise != hare)

    // Find the "entrance" to the cycle.
    var ptr1 = nums[0]
    var ptr2 = tortoise
    while (ptr1 != ptr2) {
        ptr1 = nums[ptr1]
        ptr2 = nums[ptr2]
    }

    return ptr1
}