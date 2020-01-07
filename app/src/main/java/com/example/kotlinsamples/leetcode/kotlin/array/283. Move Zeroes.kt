package com.example.kotlinsamples.leetcode.kotlin.array

fun main() {
    var arr = intArrayOf(0, 1, 0, 3, 12)
    moveZeroes3(arr)
    println(arr.toList().toString())
}

private fun moveZeroes(nums: IntArray) {
    var cnt = 0
    for (i in nums.indices) {
        if (nums[i] == 0) {
            cnt++
            for (j in i until nums.lastIndex) {
                nums[j] = nums[j + 1]
            }
        }
    }
    for (i in 1..cnt) {
        nums[nums.size - i] = 0
    }
}

private fun moveZeroes2(nums: IntArray) {
    var lastNonZero = -1
    for (i in nums.indices) {
        if (nums[i] != 0) {
            nums[++lastNonZero] = nums[i]
        }
    }
    for (i in lastNonZero + 1..nums.lastIndex) {
        nums[i] = 0
    }
}

private fun moveZeroes3(nums: IntArray) {
    var lastNonZero = -1
    for (i in nums.indices) {
        if (nums[i] != 0) {
            lastNonZero++
            if (i != lastNonZero) nums[lastNonZero] = nums[i].also { nums[i] = nums[lastNonZero] }
        }
    }
}

