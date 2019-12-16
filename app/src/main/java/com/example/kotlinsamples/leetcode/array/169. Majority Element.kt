package com.example.kotlinsamples.leetcode.array

// By Map
private fun majorityElement1(nums: IntArray): Int {
    var map = HashMap<Int, Int>()
    for (n in nums) {
        map.put(n, map.getOrDefault(n, 0))
        if (map.get(n)!! > nums.size / 2) {
            return n
        }
    }
    return 0 // This will get execute, as there is always majority present in input
}

// By sorting
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

