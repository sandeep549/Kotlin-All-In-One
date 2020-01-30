package com.example.kotlinsamples.leetcode.kotlin.math

private fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
    for (i in 0..nums.size - 2) {
        var s = nums[i]
        for (j in i + 1 until nums.size) {
            s += nums[j]
            if (s == k || (k != 0 && s % k == 0)) return true;
        }
    }
    return false
}

//use remainder theorem
private fun checkSubarraySum2(nums: IntArray, k: Int): Boolean {
    var sum = 0
    val map: HashMap<Int, Int> = HashMap()
    map[0] = -1
    for (i in nums.indices) {
        sum += nums[i]
        if (k != 0) sum %= k
        if (map.containsKey(sum)) {
            if (i - map[sum]!! > 1) return true
        } else map[sum] = i
    }
    return false
}
