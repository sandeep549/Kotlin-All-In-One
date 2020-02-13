package com.example.kotlinsamples.leetcode.kotlin.array.medium

private fun canJump(nums: IntArray): Boolean {
    var table = Array<Boolean?>(nums.size) { null }
    fun canReachLast(i: Int): Boolean {
        if (i == nums.lastIndex) return true
        if (table[i] != null) return table[i]!!
        var res = false
        for (k in 1..nums[i]) {
            res = canReachLast(i + k)
            if (res) break
        }
        table[i] = res
        return res
    }
    return canReachLast(0)
}

private fun canJump2(nums: IntArray): Boolean {
    var goodIndex = nums.size - 1
    for (i in nums.indices.reversed()) {
        if (i + nums[i] >= goodIndex) {
            goodIndex = i
        }
    }
    return goodIndex == 0
}