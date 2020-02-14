package com.example.kotlinsamples.leetcode.kotlin.array.easy

private fun containsDuplicate(nums: IntArray): Boolean {
    for (i in 0 until nums.size - 1) {
        for (j in i + 1 until nums.size) {
            if (nums[i] == nums[j]) {
                return true
            }
        }
    }
    return false
}

private fun containsDuplicate2(nums: IntArray): Boolean {
    nums.sort()
    for (i in 1 until nums.size) {
        if (nums[i] == nums[i - 1]) {
            return true
        }
    }
    return false
}

private fun containsDuplicate3(nums: IntArray): Boolean {
    var set = HashSet<Int>()
    for (n in nums) {
        if (set.contains(n)) {
            return true
        }
        set.add(n)
    }
    return false
}

private fun containsDuplicate4(nums: IntArray): Boolean {
    return nums.size > nums.toSet().size
}
