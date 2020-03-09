package com.example.kotlinsamples.leetcode.kotlin.dp.medium

/**
 * LIS ending at index i, including index i
 * L(i) = max(L(j)) + 1, where 0<=j<i and arr[j] <= arr[i]
 */
private fun lengthOfLIS(nums: IntArray): Int {
    var ans = 1
    var dp = IntArray(nums.size) { 0 } // min list will be 1 at any index, so 0 initial value is fine
    fun lis(i: Int): Int { // returns lis ending at index i, including index i
        if (i == 0) return 1
        if (dp[i] != 0) return dp[i]
        var lisHere = 1 // min value for standalone element
        for (j in 0 until i) {
            var res = lis(j)
            if (nums[i] > nums[j] && res + 1 > lisHere) lisHere = res + 1
        }
        if (lisHere > ans) ans = lisHere
        dp[i] = lisHere
        return lisHere
    }
    if (nums.isEmpty()) return 0
    lis(nums.lastIndex)
    return ans
}

fun main() {
    println(lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
}