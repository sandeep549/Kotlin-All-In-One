package com.example.kotlinsamples.leetcode.kotlin.slidingwindow

private fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
    val n = nums.size
    if (n * k == 0) return IntArray(0)
    if (k == 1) return nums

    val left = IntArray(n)
    left[0] = nums[0]
    val right = IntArray(n)
    right[n - 1] = nums[n - 1]
    for (i in 1 until n) { // from left to right
        if (i % k == 0) left[i] = nums[i] // block_start
        else left[i] = maxOf(left[i - 1], nums[i])
        // from right to left
        val j = n - i - 1
        if ((j + 1) % k == 0) right[j] = nums[j] // block_end
        else right[j] = maxOf(right[j + 1], nums[j])
    }

    val output = IntArray(n - k + 1)
    for (i in 0 until n - k + 1) output[i] = maxOf(left[i + k - 1], right[i])

    return output
}