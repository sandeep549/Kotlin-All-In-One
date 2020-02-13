package com.example.kotlinsamples.leetcode.kotlin.array.NamedAlgorithms

//https://en.wikipedia.org/wiki/Boyer%E2%80%93Moore_majority_vote_algorithm

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

