package com.example.kotlinsamples.leetcode.kotlin.array

import kotlin.math.abs
import kotlin.math.sign

fun main() {
    println(missingNumber(intArrayOf(3, 0, 1)))
    println(missingNumber(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))

    println(missingNumber2(intArrayOf(3, 0, 1)))
    println(missingNumber2(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))

    println(missingNumber3(intArrayOf(3, 0, 1)))
    println(missingNumber3(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))

    println(missingNumber4(intArrayOf(3, 0, 1)))
    println(missingNumber4(intArrayOf(9, 6, 4, 2, 3, 5, 7, 0, 1)))
}

private fun missingNumber(nums: IntArray): Int {
    return (nums.size * (nums.size + 1)) / 2 - nums.sum()
}

private fun missingNumber2(nums: IntArray): Int {
    var ans = nums.reduce { acc, i -> acc.xor(i).xor(nums[i]) }
    return ans.xor(nums.size)
}


private fun missingNumber3(nums: IntArray): Int {
    nums.sort()
    var l = 0
    var r = nums.size - 1
    while (l < r) {
        var mid = (l + r) / 2
        if (nums[mid] > mid) {
            r = mid
        } else {
            l = mid + 1
        }
    }
    return l
}

private fun missingNumber4(nums: IntArray): Int {
    // Mark all indices with element present as negative
    for (i in nums.indices) {
        if (abs(nums[i]) != nums.size) {
            nums[abs(nums[i])] = -nums[abs(nums[i])]
        }
    }

    // If any positive elment then its index is absent
    for (i in nums.indices) {
        if (nums[i].sign == 1) return i
    }

    var maxPresent = nums.max() == nums.size
    if (maxPresent) {
        // If max element is present in array, then missing is 0th index
        for (i in nums.indices) {
            if (nums[i].sign == 0) return i
        }
        return -1
    } else {
        // If max is missing in array then its missing from array
        return nums.size
    }
}