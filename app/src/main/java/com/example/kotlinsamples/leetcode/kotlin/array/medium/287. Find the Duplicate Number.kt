package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun findDuplicate(nums: IntArray): Int {
    var set = mutableSetOf<Int>()
    for (a in nums) {
        if (set.contains(a)) return a
        set.add(a)
    }
    return 0 // we must never come here
}

// O(n); floyd cycle detection
private fun findDuplicate2(nums: IntArray): Int {
    var slow = nums[0]
    var fast = nums[0]
    do {
        slow = nums[slow]
        fast = nums[nums[fast]]
    } while (slow != fast)

    // locate entrace of cycle
    fast = nums[0]
    while (fast != slow) {
        fast = nums[fast]
        slow = nums[slow]
    }
    return slow
}