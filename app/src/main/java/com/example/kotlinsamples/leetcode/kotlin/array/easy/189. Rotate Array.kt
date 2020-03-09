package com.example.kotlinsamples.leetcode.kotlin.array.easy

// time-O(n^2); n is size of array
private fun rotate(nums: IntArray, k: Int) {
    val count = k % nums.size
    for (i in 1..count) {
        val last = nums[nums.lastIndex]
        for (j in nums.lastIndex downTo 1) {
            nums[j] = nums[j - 1]
        }
        nums[0] = last
    }
}

// time-O(n), space-O(n); n is size of array
private fun rotate2(nums: IntArray, k: Int) {
    val rotation = k % nums.size
    val a = IntArray(nums.size)
    for (i in nums.indices) {
        a[(i + rotation) % nums.size] = nums[i]
    }
    for (i in a.indices) {
        nums[i] = a[i]
    }
}

// time-O(n), space-O(1); n is size of array
private fun rotate4(nums: IntArray, k: Int) {
    var rotation = k % nums.size
    var swap = 0
    var startIdx = 0
    while (startIdx < nums.size) {
        var currIdx = startIdx
        var prev = nums[startIdx]
        do {
            val nextIdx = (currIdx + rotation) % nums.size
            val temp = nums[nextIdx]
            nums[nextIdx] = prev
            prev = temp
            currIdx = nextIdx
            swap++
            if (swap == nums.size) return
        } while (startIdx != currIdx)
        startIdx++
    }
}

// Recursive; time-O(n), space-O(1); n is size of array
private fun rotate3(nums: IntArray, k: Int) {
    val rotation = k % nums.size
    var swap = 0
    var startIdx = 0
    fun cycle(index: Int, element: Int) {
        var tmp = nums[index]
        nums[index] = element
        swap++
        if (swap >= nums.size) return
        if (index == startIdx) {
            startIdx++
            cycle(startIdx + rotation, nums[startIdx])
        } else {
            cycle((index + rotation) % nums.size, tmp)
        }
    }
    cycle(startIdx + rotation, nums[startIdx])
}

private fun rotate5(nums: IntArray, k: Int) {
    val rotation = k % nums.size
    fun reverseInRange(nums: IntArray, start: Int, end: Int) {
        var l = start
        var r = end
        while (l < r) {
            nums[l] = nums[r].also { nums[r] = nums[l] }
            l++
            r--
        }
    }
    reverseInRange(nums, 0, nums.size - 1)
    reverseInRange(nums, 0, rotation - 1)
    reverseInRange(nums, rotation, nums.size - 1)
}