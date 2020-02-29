package com.example.kotlinsamples.leetcode.kotlin.misc

private fun increasingTriplet(nums: IntArray): Boolean {
    for (i in 0..nums.lastIndex - 2) {
        for (j in i + 1 until nums.lastIndex) {
            for (k in j + 1 until nums.size) {
                if (nums[i] < nums[j] && nums[k] > nums[j]) return true
            }
        }
    }
    return false
}

private fun increasingTriplet2(nums: IntArray): Boolean {
    var small = Int.MAX_VALUE
    var big = Int.MAX_VALUE
    for (n in nums) {
        if (n <= small) small = n // update small if n is smaller than both
        else if (n <= big) big = n // update big only if greater than small but smaller than big
        else return true // return if you find a number bigger than both
    }
    return false
}

fun main() {
    println(increasingTriplet(intArrayOf(5, 2, 5, 5, 4, 0, 6)))
}