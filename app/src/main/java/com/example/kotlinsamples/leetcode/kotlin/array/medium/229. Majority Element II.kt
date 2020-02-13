package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun majorityElement(nums: IntArray): List<Int> {
    val l = nums.size / 3
    val g = nums
        .toList()
        .groupingBy { it }
        .eachCount()
        .filter { it.value > l }
        .map { it.key }
    return g
}

private fun majorityElement2(nums: IntArray): List<Int> {
    var ans = mutableListOf<Int>()
    if (nums.isEmpty()) return ans
    var a = 0
    var b = 1
    var ca = 0
    var cb = 0
    for (x in nums) {
        if (x == a) ca++
        else if (x == b) cb++
        else if (ca == 0) {
            a = x
            ca = 1
        } else if (cb == 0) {
            b = x
            cb = 1
        } else {
            ca--
            cb--
        }
    }

    ca = 0.also { cb = 0 }
    for (x in nums)
        if (x == a) ca++
        else if (x == b) cb++
    if (ca > nums.size / 3) ans.add(a)
    if (cb > nums.size / 3) ans.add(b)
    return ans
}