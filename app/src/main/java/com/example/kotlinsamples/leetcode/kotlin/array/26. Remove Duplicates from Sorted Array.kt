package com.example.kotlinsamples.leetcode.kotlin.array

fun main() {
    var a = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)
    removeDuplicates(a)
    println(a.toList())
}

private fun removeDuplicates(nums: IntArray): Int {
    var count = 0
    for (i in 1 until nums.size) {
        if (nums[i] == nums[i - 1])
            count++
        else
            nums[i - count] = nums[i]
    }
    return nums.size - count
}

private fun removeDuplicates2(nums: IntArray): Int {
    var i = 0
    var j = 0
    while (j < nums.size) {
        if (nums[i] != nums[j]) nums[++i] = nums[j]
        j++
    }
    return ++i
}

private fun removeDuplicates3(nums: IntArray): Int {
    var i = 0
    var j = 0
    while (j < nums.size) {
        while (j < nums.size && nums[i] == nums[j]) j++
        if (j < nums.size && ++i != j) {
            nums[i] = nums[j]
        }
    }
    return i + 1
}