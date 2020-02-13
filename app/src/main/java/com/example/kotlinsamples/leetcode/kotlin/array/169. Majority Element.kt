package com.example.kotlinsamples.leetcode.kotlin.array

import android.annotation.SuppressLint

//brute force
//O(n^2)
private fun majorityElement(nums: IntArray): Int {
    for (i in 0 until nums.lastIndex) {
        var cnt = 1
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] == nums[j]) {
                cnt++
                if (cnt > nums.size / 2) return i
            }
        }
    }
    return nums[0]
}

// By Map
//O(n);O(n)
@SuppressLint("NewApi")
private fun majorityElement1(nums: IntArray): Int {
    val map = mutableMapOf<Int, Int>()
    for (n in nums) {
        map[n] = map.getOrDefault(n, 0)
        map[n]?.let { if (it > nums.size / 2) return n }
    }
    return 0 // This will get execute, as there is always majority present in input
}

// By sorting
//O(nlogn)
private fun majorityElement2(nums: IntArray): Int {
    nums.sort()
    return nums[nums.size / 2]
}

// Boyer - Moore
private fun majorityElement3(nums: IntArray): Int {
    var major = nums[0]
    var count = 1
    for (i in 1 until nums.size) {
        if (count == 0) {
            major = nums[i]
        }
        count += if (nums[i] == major) 1 else -1
    }
    return major
}

