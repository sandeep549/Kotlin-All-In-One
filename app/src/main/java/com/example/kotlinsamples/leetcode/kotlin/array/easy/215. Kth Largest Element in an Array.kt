package com.example.kotlinsamples.leetcode.kotlin.array.easy

import android.annotation.SuppressLint
import java.util.*

private fun findKthLargest(nums: IntArray, k: Int): Int {
    nums.sort()
    return nums[nums.size - k]
}

@SuppressLint("NewApi")
private fun findKthLargest2(nums: IntArray, k: Int): Int {
    var priorityQueue = PriorityQueue<Int> { i1, i2 -> i1 - i2 }
    for (num in nums) {
        priorityQueue.add(num)
        if (priorityQueue.size > k) priorityQueue.poll()
    }
    return priorityQueue.poll()
}

// todo: check quick select algorithms for O(n) result
// https://leetcode.com/problems/kth-largest-element-in-an-array/solution/
// https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60294/Solution-explained
// https://leetcode.com/problems/kth-largest-element-in-an-array/discuss/60312/AC-Clean-QuickSelect-Java-solution-avg.-O(n)-time
